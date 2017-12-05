Survey.Survey.cssType = "bootstrap";
Survey.defaultBootstrapCss.navigationButton = "btn btn-green";

$.ajax({url: window.location.origin + "/survey1"})
    .then(function (json) {
        window.survey = new Survey.Model(json);


        survey.onComplete.add(function (result) {
            document.querySelector('#surveyResult').innerHTML = "result: " + JSON.stringify(result.data);
        });
        $("#surveyElement").Survey({
            model: survey
        });
    });

