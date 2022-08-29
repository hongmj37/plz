package pre.project.server.domain.question.service;

import pre.project.server.domain.question.entity.Question;
import pre.project.server.dto.QuestionPatchDto;
import pre.project.server.dto.RequestDto;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    Question create(RequestDto requestDto);

    Question read(Long id);

    List<Question> readAll();

    Question update(QuestionPatchDto requestDto);

    void delete(Long id);
}
