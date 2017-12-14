package pl.khuzzuk.survey.db;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.khuzzuk.survey.surveys.answers.LogicTestAnswer;
import pl.khuzzuk.survey.surveys.answers.LogicTestAnswersDTO;

@Mapper(componentModel = "spring")
public interface EntityMapper {
    EntityMapper map = Mappers.getMapper(EntityMapper.class);

    LogicTestAnswer from(LogicTestAnswersDTO dto);
}
