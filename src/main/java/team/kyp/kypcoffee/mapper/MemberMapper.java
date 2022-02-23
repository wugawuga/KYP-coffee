package team.kyp.kypcoffee.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import team.kyp.kypcoffee.domain.User.User;
import team.kyp.kypcoffee.domain.Member;

import java.util.List;

@Mapper
public interface MemberMapper {
    void insertMember(Member member);
    void insertMemberInfo(Member member);//mapper의 id 이름과 같아야함

    //Member selectById(@Param("memberId") String memberId);
    List<Member> selectByIdList(String memberId);

    Member selectById(String memberId);
    Member selectByIdAll(String id);
    Member selectByEmail(String memberEmail);

    User findByEmail(String email);
    void save(User user);
}
