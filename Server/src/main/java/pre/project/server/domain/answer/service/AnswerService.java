package pre.project.server.domain.answer.service;

import pre.project.server.domain.answer.entity.Answer;
import pre.project.server.dto.AnswerRequestDto;

public interface AnswerService {

    Long answerSave(Long id, AnswerRequestDto dto);
}
