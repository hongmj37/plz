package pre.project.server.domain.answer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pre.project.server.domain.answer.entity.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
