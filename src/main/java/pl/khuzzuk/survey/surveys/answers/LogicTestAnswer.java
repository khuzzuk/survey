package pl.khuzzuk.survey.surveys.answers;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class LogicTestAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String q1;
    @ElementCollection
    private List<String> q2;
    private String q3;
    private String q4;
    private float timeForTest;
    private float timeSpent;
    private float score;
}
