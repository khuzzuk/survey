package pl.khuzzuk.survey.surveys;

import java.util.List;

public class SurveyModel {
    List<QuestionModel> questions;

    public List<QuestionModel> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionModel> questions) {
        this.questions = questions;
    }
}
