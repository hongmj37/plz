package pre.project.server.domain.answer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pre.project.server.domain.answer.entity.Answer;
import pre.project.server.domain.answer.repository.AnswerRepository;
import pre.project.server.domain.question.entity.Question;
import pre.project.server.domain.question.repository.QuestionRepository;
import pre.project.server.dto.AnswerRequestDto;
import pre.project.server.dto.AnswerResponseDto;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    // CREATE
    @Transactional
    public Long answerSave(Long id, AnswerRequestDto dto) {
        Question question = questionRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
        dto.setQuestion(question); // Question의 정보를 answer에 저장

        Answer answer = dto.toEntity();

        return dto.getAnswerId();
    }

    // READ
    @Transactional(readOnly = true)
    public List<AnswerResponseDto> findAll(Long id) {
        Question question = questionRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
        List<Answer> answers = question.getAnswers();
        return answers.stream().map(AnswerResponseDto::new).collect(Collectors.toList());
    }

    /* UPDATE */
    @Transactional
    public void update(Long id, AnswerRequestDto dto) {
        Answer answer = answerRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 댓글이 존재하지 않습니다."));


    }

    /* DELETE */
    @Transactional
    public void delete(Long id) {
        Answer answer = answerRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 댓글이 존재하지 않습니다. id=" + id));

        answerRepository.delete(answer);
    }
}
