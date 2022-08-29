package pre.project.server.domain.question.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pre.project.server.domain.question.entity.Question;
import pre.project.server.domain.question.repository.QuestionRepository;
import pre.project.server.dto.QuestionPatchDto;
import pre.project.server.dto.RequestDto;

import java.util.List;

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
        Question question = questionRepository.findById(id).get();
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
        Question question = questionRepository.findById(patchDto.getQuestionId()).get();
        question.setTitle(patchDto.getTitle());
        question.setContent(patchDto.getContent());

        return questionRepository.save(question);
    }

    /**
     * 삭제
     */
    public void delete(Long id){
        Question question = questionRepository.findById(id).get();
        questionRepository.delete(question);
    }
}