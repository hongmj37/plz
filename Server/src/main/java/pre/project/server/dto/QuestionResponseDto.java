package pre.project.server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pre.project.server.domain.question.entity.Question;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionResponseDto {
    private Long questionId;
    private String title;

    private String content;
    private int recommendNum;
    private LocalDateTime regDate;
    private LocalDateTime editDate;
    private int viewNum;


    public QuestionResponseDto(Question question) {
        this.questionId = question.getQuestionId();
        this.title = question.getTitle();
        this.content = question.getContent();
        this.recommendNum = question.getRecommendNum();
        this.viewNum = question.getViewNum();
        this.regDate = question.getRegDate();
        this.editDate = question.getEditDate();
    }
}
