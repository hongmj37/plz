package pre.project.server.answer.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private int answerId;

    @Column(nullable = false)
    private String contents;

    @Column(nullable=false, updatable = false)
    private LocalDateTime regDate;

    private Date editDate;

    private int recommendNum;

    @Column(nullable = false)
    private int questionId;
}
