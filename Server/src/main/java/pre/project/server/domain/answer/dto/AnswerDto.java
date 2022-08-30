package pre.project.server.domain.answer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class AnswerDto {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request {
        private Long questionId;
        private String title;
        private String content;
        private int recommendNum;
        private LocalDateTime regDate;
        private LocalDateTime editDate;
        private int viewNum;
    }
}
