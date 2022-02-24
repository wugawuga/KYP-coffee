package team.kyp.kypcoffee.mapper;

import org.apache.ibatis.annotations.Mapper;
import team.kyp.kypcoffee.domain.QnaBoard;

import java.util.List;

@Mapper
public interface QnaBoardMapper {
    List<QnaBoard> selectAllList();

}
