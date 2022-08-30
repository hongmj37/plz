package pre.project.server.domain.question.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pre.project.server.domain.question.service.QuestionService;
import pre.project.server.domain.question.service.QuestionServiceImpl;
import pre.project.server.domain.question.entity.Question;
import pre.project.server.dto.MultiResponseDto;
import pre.project.server.dto.QuestionPatchDto;
import pre.project.server.dto.RequestDto;
import pre.project.server.dto.QuestionResponseDto;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    /**
     * 전체 게시글 조회
     */
    @GetMapping
    public ResponseEntity readQuestions(@Positive @RequestParam int page,
                                        @Positive @RequestParam int size) {
        Page<Question> pageQuestions = questionService.readAll(page - 1 ,size);
        List<Question> question = pageQuestions.getContent();
        return ResponseEntity.ok(
                new MultiResponseDto(question,pageQuestions));
    }


    /**
     * 게시글 하나 조회
     */
    @GetMapping("/{question-id}")
    public ResponseEntity readQuestion(@PathVariable("question-id") Long id) {
        Question questionResult = questionService.read(id);
        return ResponseEntity.ok(new QuestionResponseDto(questionResult));
    }

    /**
     * 게시글 등록
     */
    @PostMapping
    public ResponseEntity<QuestionResponseDto> createQuestion(@RequestBody RequestDto requestDto) {
        Question questionResult = questionService.create(requestDto);
        return ResponseEntity.ok(new QuestionResponseDto(questionResult));
    }

    /**
     * 게시글 수정
     */
    @PatchMapping("/{question-id}")
    public ResponseEntity updateQuestion(@PathVariable("question-id") Long id, @RequestBody QuestionPatchDto patchDto) {
        patchDto.setQuestionId(id);
        Question questionResult = questionService.update(patchDto);
        return ResponseEntity.ok(new QuestionResponseDto(questionResult));
    }

    /**
     * 게시글 삭제
     */
    @DeleteMapping("/{question-id}")
    public ResponseEntity deleteQuestion(@PathVariable("question-id") Long id) {
        questionService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}

