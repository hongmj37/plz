package pre.project.server.question.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionResponse {
    private int questionId;
    private String title;
    private String contents;
    private int recommendNum;
    private LocalDateTime regDate;
    private LocalDateTime editDate;
    private int viewNum;
    // private SkillTag skillTag;

    public QuestionResponse(Question question) {
        this.questionId = question.getQuestionId();
        this.title = question.getTitle();
        this.contents = question.getContents();
        this.recommendNum = question.getRecommendNum();
        this.viewNum = question.getViewNum();
        this.regDate = question.getRegDate();
        this.editDate = question.getEditDate();
        //this.skillTag = question.getSkillTag();
    }
}
