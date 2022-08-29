package pre.project.server.domain.question.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pre.project.server.domain.question.repository.QuestionRepository;
import pre.project.server.domain.question.entity.Question;
import pre.project.server.dto.QuestionPatchDto;
import pre.project.server.dto.RequestDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;

    /**
     * 작성
     */
    public Question create(RequestDto requestDto) {
        Question question = new Question();
        question.setTitle(requestDto.getTitle());
        question.setContent(requestDto.getContent());

        return questionRepository.save(question);
    }

    /**
     * 조회
     */
    public Question read(Long id){
        Question question = findQuestion(id);
        return question;
    }

    /**
     * 전체 조회
     */
    public List<Question> readAll(){
        List<Question> question = questionRepository.findAll();
        return question;
    }

    /**
     * 수정
     */
    public Question update(QuestionPatchDto patchDto) {
        Question question = findQuestion(patchDto.getQuestionId());

        Optional.ofNullable(patchDto.getTitle())
                        .ifPresent(title -> question.setTitle(title));
        Optional.ofNullable(patchDto.getContent())
                        .ifPresent(content -> question.setContent(content));
        question.setEditDate(LocalDateTime.now());

        return questionRepository.save(question);
    }

    /**
     * 삭제
     */
    public void delete(Long id){
        Question question = findQuestion(id);
        questionRepository.delete(question);
    }

    public Question findQuestion(Long questionId) {
        Optional<Question> optionalQuestion = questionRepository.findById(questionId);
        Question findQuestion = optionalQuestion.orElseThrow(() -> new NullPointerException());
        return findQuestion;
    }
}