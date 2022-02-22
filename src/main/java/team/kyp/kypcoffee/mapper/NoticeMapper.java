package team.kyp.kypcoffee.mapper;

import org.apache.ibatis.annotations.Mapper;
import team.kyp.kypcoffee.domain.Notice;
import team.kyp.kypcoffee.domain.Paging;

import java.util.List;

@Mapper
public interface NoticeMapper {

    List<Notice> selectAll();

    List<Notice> selectPaging(Paging paging);

    int selectAllNumber();

}
