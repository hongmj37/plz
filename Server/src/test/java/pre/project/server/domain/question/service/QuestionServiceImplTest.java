package pre.project.server.domain.question.service;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import pre.project.server.domain.question.entity.Question;
import pre.project.server.domain.question.repository.QuestionRepository;
import pre.project.server.dto.RequestDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

// 질문 서비스 기능 슬라이스 테스트
@ExtendWith(MockitoExtension.class)
class QuestionServiceImplTest {

    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private QuestionServiceImpl questionService;

    @Test
    void create() throws Exception {

        // given
        RequestDto requestDto = new RequestDto("title","content");

        Question newQuestion = new Question(1L, "title", "content", LocalDateTime.now(), LocalDateTime.now(), 0, 0, new ArrayList<>());

        // mocking
        given(questionRepository.save(any()))
                .willReturn(newQuestion);

        // when
        Question actualQuestion = questionService.create(requestDto);

        //then
        assertEquals(newQuestion.getQuestionId(), actualQuestion.getQuestionId());
        assertEquals(newQuestion.getTitle(), actualQuestion.getTitle());
        assertEquals(newQuestion.getContent(), actualQuestion.getContent());
    }

    @Test
    void read() {
    }

    @Test
    void readAll() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}