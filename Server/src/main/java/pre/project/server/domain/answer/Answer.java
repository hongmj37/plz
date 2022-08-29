package pre.project.server.domain.answer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pre.project.server.domain.question.entity.Question;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;

    @Column(nullable = false)
    private String content;

    @Column(nullable=false, updatable = false)
    private LocalDateTime regDate=LocalDateTime.now();

    private LocalDateTime editDate=LocalDateTime.now();

    private int recommendNum;

    @ManyToOne
    @JoinColumn(name = "questionId")
    private Question question;

    public void addQuestion(Question question){
        this.question = question;
    }
}
