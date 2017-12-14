package pl.khuzzuk.survey.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.khuzzuk.survey.db.EntityMapper;
import pl.khuzzuk.survey.db.LogicTestAnswerRepo;
import pl.khuzzuk.survey.surveys.answers.LogicTestAnswer;
import pl.khuzzuk.survey.surveys.answers.LogicTestAnswersDTO;

import java.io.IOException;

@RestController
public class ResultDumper {
    @Autowired
    private LogicTestAnswerRepo repo;
    @Autowired
    private EntityMapper mapper;

    @PostMapping("result")
    public String dumpResult(@RequestBody LogicTestAnswersDTO answers) throws IOException {
        float score = 0;
        if ("nie".equals(answers.getQ1())) score++;
        if ("dłuższy niż za pierwszym razem".equals(answers.getQ3())) score++;
        if (answers.getQ2() != null && answers.getQ2().size() == 1 && answers.getQ2().get(0).equals("Donald jest kaczką")) score++;
        if ("11".equals(answers.getQ4())) score++;

        score = score * (answers.getTimeForTest() / answers.getTimeSpent());

        LogicTestAnswer toPersist = mapper.from(answers);
        toPersist.setScore(score);
        repo.save(toPersist);
        return String.valueOf((int) score);
    }

    @GetMapping("allResults")
    public Iterable<LogicTestAnswer> getAnswers() {
        return repo.findAll();
    }
}
