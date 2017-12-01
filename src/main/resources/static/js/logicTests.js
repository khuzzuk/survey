Survey.Survey.cssType = "bootstrap";
Survey.defaultBootstrapCss.navigationButton = "btn btn-green";

var q1Text = 'Wszystkie psy szczekają, Donald szczeka, czy donald jest psem?';

var json = {
    questions: [
        {
            name: "q1",
            type: "radiogroup",
            title: q1Text,
            colCount: 1,
            choices: ["tak","nie"],
            isRequired: true
        }
    ]
};

window.survey = new Survey.Model(json);


survey.onComplete.add(function (result) {
    document.querySelector('#surveyResult').innerHTML = "result: " + JSON.stringify(result.data);
});


$("#surveyElement").Survey({
    model: survey
});