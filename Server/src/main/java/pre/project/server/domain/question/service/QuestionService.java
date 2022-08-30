package pre.project.server.domain.question.service;

import org.springframework.data.domain.Page;
import pre.project.server.domain.question.entity.Question;
import pre.project.server.dto.QuestionPatchDto;
import pre.project.server.dto.RequestDto;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    /**
     * 게시글 작성
     * @param requestDto
     * @return
     */
    Question create(RequestDto requestDto);

    /**
     * 게시글 조회
     * @param questionId
     * @return
     */
    Question read(Long questionId);

    /**
     * 게시글 전체 조회
     * @param page
     * @param size
     * @return
     */
    Page<Question> readAll(int page, int size);

    /**
     * 게시글 수정
     * @param requestDto
     * @return
     */
    Question update(QuestionPatchDto requestDto);

    /**
     * 게시글 삭제
     * @param questionId
     */
    void delete(Long questionId);
}
