package pl.khuzzuk.survey.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.khuzzuk.survey.surveys.answers.LogicTestAnswers;

import java.io.IOException;

@RestController
public class ResultDumper {
    @PostMapping("result")
    public String dumpResult(@RequestBody LogicTestAnswers answers) throws IOException {
        int score = 0;
        if ("nie".equals(answers.getQ1())) score++;
        if ("dłuższy niż za pierwszym razem".equals(answers.getQ2())) score++;

        return String.valueOf(score);
    }
}
