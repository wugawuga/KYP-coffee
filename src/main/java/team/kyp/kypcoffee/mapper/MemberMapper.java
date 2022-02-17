package team.kyp.kypcoffee.mapper;

import org.apache.ibatis.annotations.Mapper;
import team.kyp.kypcoffee.domain.Member;

import java.util.List;

@Mapper
public interface MemberMapper {

    List<Member> selectAll();

}
