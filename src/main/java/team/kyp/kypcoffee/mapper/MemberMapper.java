package team.kyp.kypcoffee.mapper;

import org.apache.ibatis.annotations.Mapper;
import team.kyp.kypcoffee.domain.User.Kakao;
import team.kyp.kypcoffee.domain.User.User;
import team.kyp.kypcoffee.domain.Member;

import java.util.List;

@Mapper
public interface MemberMapper {
    void insertMember(Member member);
    void insertMemberInfo(Member member);//mapper의 id 이름과 같아야함
    void updateMember(Member member);
    void updateMemberGoogle(Member member);
    void deleteMember(Integer memberNum);
    void deleteMemberGoogle(String memberEmail);

    //Member selectById(@Param("memberId") String memberId);
    List<Member> selectByIdList(String memberId);

    Member selectById(String memberId);
    Member selectByIdAll(String id);
    Member selectByMnum(Integer memberNum);
    Member selectByEmail(String memberEmail);

    Member selectByEmailOnly(String memberEmail);

    User findByEmail(String email);
    Kakao findByEmailKakao(String email);
    void save(User user);
    void saveKakao(Kakao kakao);
}
