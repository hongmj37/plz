package pre.project.server.domain.question.service;

import org.springframework.data.domain.Page;
import pre.project.server.domain.question.entity.Question;
import pre.project.server.dto.QuestionPatchDto;
import pre.project.server.dto.RequestDto;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    Question create(RequestDto requestDto);

    Question read(Long id);

    Page<Question> readAll(int page, int size);

    Question update(QuestionPatchDto requestDto);

    void delete(Long id);
}
