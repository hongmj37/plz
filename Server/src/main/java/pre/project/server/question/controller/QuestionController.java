package pre.project.server.question.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pre.project.server.question.entity.Question;
import pre.project.server.question.entity.QuestionRequest;
import pre.project.server.question.entity.QuestionResponse;
import pre.project.server.question.service.QuestionService;

@Controller
@RequestMapping("/questions/")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    /**
     * 전체 게시글 조회
     */
    @GetMapping
    public ResponseEntity getQuestions() {
        return null;
    }
    /**
     * 게시글 하나 조회
     */
    @GetMapping("{question-id}")
    public ResponseEntity getQuestion() {
        return null;
    }

    /**
     * 게시글 등록
     */
    @PostMapping
    public ResponseEntity<QuestionResponse> postQuestion(@RequestBody QuestionRequest questionRequest) {
        Question questionResult = questionService.post(questionRequest);
        return ResponseEntity.ok(new QuestionResponse(questionResult));
    }

    /**
     * 게시글 수정
     */
    @PatchMapping("{question-id}")
    public ResponseEntity patchQuestion(@PathVariable int id, @RequestBody QuestionRequest questionRequest) {
        return null;
    }

    /**
     * 게시글 삭제
     */
    @DeleteMapping("{question-id}")
    public ResponseEntity deleteQuestion() {
        return null;
    }

}

