package team.kyp.kypcoffee.mapper;

import org.apache.ibatis.annotations.Mapper;
import team.kyp.kypcoffee.domain.Notice;

import java.util.List;

@Mapper
public interface NoticeMapper {

    List<Notice> selectAll();
}
