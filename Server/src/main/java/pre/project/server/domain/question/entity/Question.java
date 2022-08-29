package pre.project.server.domain.question.entity;

import lombok.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import pre.project.server.domain.answer.Answer;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long questionId;

    @Column(nullable=false)
    private String title;

    @Column(nullable=false)
    private String content;

    @Column(nullable=false, updatable = false)
    private LocalDateTime regDate= LocalDateTime.now();

    private LocalDateTime editDate = LocalDateTime.now();

    private int viewNum = 0;

    private int recommendNum = 0;

    @OneToMany(mappedBy = "question")
    List<Answer> answers = new ArrayList<>();

    public void addAnswers(Answer answer){
        this.answers.add(answer);
    }

}
