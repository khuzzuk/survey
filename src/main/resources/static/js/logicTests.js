Survey.Survey.cssType = "bootstrap";
Survey.defaultBootstrapCss.navigationButton = "btn btn-green";

var timeElement = $("#timeElement");
var progressBar = $("#progressbar");
var timeSpent;
var timeForTest= 0.1*60;

function refreshTimer() {
    if (!timeElement) return;
    var timeLeft = timeForTest - timeSpent;

    if (timeLeft <= 0) {
        survey.completeLastPage();
        timeElement.hide();
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
            timeElement.hide();
            progressBar.hide();
            var jsonResult = JSON.stringify(result.data);
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
        window.setInterval(timer, 1000);
    });
