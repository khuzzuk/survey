package pl.khuzzuk.survey.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.khuzzuk.survey.surveys.answers.LogicTestAnswer;

@Repository
public interface LogicTestAnswerRepo extends CrudRepository<LogicTestAnswer, Long> {
}
