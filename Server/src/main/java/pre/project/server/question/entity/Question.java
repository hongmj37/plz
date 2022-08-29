package pre.project.server.question.entity;

import lombok.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Data
public class Question {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int questionId;

    @Column(nullable=false)
    private String title;

    @Column(nullable=false)
    private String contents;

    @Column(nullable=false, updatable = false)
    @ColumnDefault("CURRENT_TIMESTAMP")
    private LocalDateTime regDate;

    @ColumnDefault("CURRENT_TIMESTAMP")
    private LocalDateTime editDate;

    @ColumnDefault("0")
    private int viewNum;

    @ColumnDefault("0")
    private int recommendNum;

    // private SkillTag skillTag;
}
