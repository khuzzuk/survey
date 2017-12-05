package pl.khuzzuk.survey.surveys;

import java.util.List;

public class SurveyPages {
    private List<SurveyPage> pages;
    private String completedHtml;

    public List<SurveyPage> getPages() {
        return pages;
    }

    public void setPages(List<SurveyPage> pages) {
        this.pages = pages;
    }

    public String getCompletedHtml() {
        return completedHtml;
    }

    public void setCompletedHtml(String completedHtml) {
        this.completedHtml = completedHtml;
    }
}
