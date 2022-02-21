package team.kyp.kypcoffee.mapper;

import org.apache.ibatis.annotations.Mapper;
import team.kyp.kypcoffee.domain.User.User;
import team.kyp.kypcoffee.domain.Member;

@Mapper
public interface MemberMapper {
    void insertMember(Member member); //mapper의 id 이름과 같아야함
    //Member selectById(@Param("memberId") String memberId);
    Member selectById(String memberId);
    User findByEmail(String email);
    void save(User user);
}
