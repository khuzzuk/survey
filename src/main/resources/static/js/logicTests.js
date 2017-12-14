Survey.Survey.cssType = "bootstrap";
Survey.defaultBootstrapCss.navigationButton = "btn btn-green";

var timeElement = $("#timeElement");
var progressBar = $("#progressbar");
var timeForTest= 30*60;
var timeSpent;
var intervalId;

function refreshTimer() {
    if (!timeElement) return;
    var timeLeft = timeForTest - timeSpent;

    if (timeLeft <= 0) {
        survey.completeLastPage();
    }
    var minutes = Math.floor(timeLeft / 60);
    var seconds = Math.floor(timeLeft % 60);
    $("#timeElement").text("pozostało " + minutes + ":" + seconds);
    progressBar.progressbar({value: 100 * timeLeft / timeForTest})
}

function timeCallback() {
    if (survey.currentPageNo === 1) {
        if (typeof timeSpent === 'undefined') {
            timeSpent = 0;
            progressBar.innerHTML = " ";
        } else {
            timeSpent = timeSpent + 1;
            refreshTimer();
        }
    }
}

function finishSurvey() {
    window.clearInterval(intervalId);
    timeElement.hide();
    progressBar.hide();
}

var doOnCurrentPageChanged = function() {
    survey.showPrevButton = false;
};

var timer = function () {
    timeCallback();
};
$.ajax({url: window.location.origin + "/survey1"})
.then(function (json) {

        window.survey = new Survey.Model(json);
        survey.onComplete.add(function (result) {
            finishSurvey();
            var surveyData = result.data;
            surveyData.timeSpent = timeSpent;
            surveyData.timeForTest = timeForTest;
            var jsonResult = JSON.stringify(surveyData);
            $.ajax({
                type: 'POST',
                url: 'result',
                contentType: "application/json",
                dataType: 'json',
                data: jsonResult
            }).then(function (data, status) {
                $('#scoreValue').text('Twój wynik to ' + data);
            });
        });
        $("#surveyElement").Survey({
            model: survey,
            onCurrentPageChanged: doOnCurrentPageChanged
        });
        intervalId = window.setInterval(timer, 1000);
    });
