package pre.project.server.domain.answer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pre.project.server.domain.answer.service.AnswerService;
import pre.project.server.dto.AnswerRequestDto;
import pre.project.server.dto.AnswerResponseDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/questions/{id}/answers")
public class AnswerController {
    private final AnswerService answerService;

    @PostMapping
    public ResponseEntity answerSave(@PathVariable Long id, @RequestBody AnswerRequestDto dto) {
        return ResponseEntity.ok(answerService.answerSave(id, dto));
    }

    /*
    @GetMapping
    public List<AnswerResponseDto> read(@PathVariable Long id) {
        return answerService
    }
     */
}
