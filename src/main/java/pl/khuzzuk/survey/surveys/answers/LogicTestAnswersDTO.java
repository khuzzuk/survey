package pl.khuzzuk.survey.surveys.answers;

import lombok.Data;

import java.util.List;

@Data
public class LogicTestAnswersDTO {
    private String email;
    private String q1;
    private List<String> q2;
    private String q3;
    private String q4;
    private float timeForTest;
    private float timeSpent;
}
