package pre.project.server.domain.question.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pre.project.server.domain.question.entity.Question;
import pre.project.server.domain.question.repository.QuestionRepository;
import pre.project.server.dto.QuestionPatchDto;
import pre.project.server.dto.RequestDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;

    public Question create(RequestDto requestDto) {
        Question question = new Question();
        question.setTitle(requestDto.getTitle());
        question.setContent(requestDto.getContent());

        return questionRepository.save(question);
    }

    public Question read(Long questionId){
        Question question = findQuestion(questionId);
        return question;
    }


    public Page<Question> readAll(int page, int size){
        return questionRepository.findAll(PageRequest.of(page,size,
                Sort.by("questionId").descending()));
    }
 
    public Question update(QuestionPatchDto patchDto) {
        Question question = findQuestion(patchDto.getQuestionId());

        Optional.ofNullable(patchDto.getTitle())
                        .ifPresent(title -> question.setTitle(title));
        Optional.ofNullable(patchDto.getContent())
                        .ifPresent(content -> question.setContent(content));
        question.setEditDate(LocalDateTime.now());

        return questionRepository.save(question);
    }

    public void delete(Long questionId){
        Question question = findQuestion(questionId);
        questionRepository.delete(question);
    }

    @Transactional(readOnly = true)
    public Question findQuestion(Long questionId) {
        Optional<Question> optionalQuestion = questionRepository.findById(questionId);
        Question findQuestion = optionalQuestion.orElseThrow(() -> new NullPointerException());
        return findQuestion;
    }
}