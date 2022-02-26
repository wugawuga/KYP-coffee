package team.kyp.kypcoffee.mapper;

import org.apache.ibatis.annotations.Mapper;
import team.kyp.kypcoffee.domain.QnaBoard;
import team.kyp.kypcoffee.domain.QnaBoardWrite;

import java.util.List;

@Mapper
public interface QnaBoardMapper {
    List<QnaBoard> selectAllList();
    QnaBoard selectView(Integer qnaBoardNum);

    void insertBoard(QnaBoard qnaBoard);
    void deleteBoard(Integer qnaBoardNum);
    void updateBoard(QnaBoard qnaBoard);
}
