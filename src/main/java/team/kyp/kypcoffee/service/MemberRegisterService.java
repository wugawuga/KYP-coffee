package team.kyp.kypcoffee.service;

import com.sun.istack.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.kyp.kypcoffee.domain.Member;
import team.kyp.kypcoffee.domain.QnaBoard;
import team.kyp.kypcoffee.domain.QnaBoardWrite;
import team.kyp.kypcoffee.domain.RegisterRequest;
import team.kyp.kypcoffee.mapper.MemberMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberRegisterService {

    @Autowired
    MemberMapper mapper;

    @Transactional
    public void register(RegisterRequest req){

        Member newMember = new Member(req.getNo(), req.getId(), req.getPw(), req.getName(),req.getBirth(),req.getAddress(),
                req.getTel(), req.getPhone(),req.getEmail(), req.getEmailyn(),req.getPoint());
        Member newMemberInfo = new Member(req.getNo(),req.getType());

        mapper.insertMember(newMember);
        mapper.insertMemberInfo(newMemberInfo);
    }

    @Transactional
    public List<Member> selectByIdList(String memberId) { //리스트로 출력시
       List<Member> list = mapper.selectByIdList(memberId);
       return list;
    }
    @Transactional
    public Member selectByIdAll(String memberId) {
        Member member = mapper.selectByIdAll(memberId);

        return member;
    }

    @Transactional
    public Member selectById(String memberId) {
        Member member = mapper.selectById(memberId);

        return member;
    }

    @Transactional
    public Member selectByEmail(String memberEmail) {
        Member member = mapper.selectByEmail(memberEmail);

        return member;
    }

    @Transactional
    public Member selectByMnum(Integer memberNum) {
        Member member = mapper.selectByMnum(memberNum);

        return member;
    }

    @Transactional
    public void update(RegisterRequest req) {

        Member member = mapper.selectByMnum(req.getNo());
        System.out.println(member.getMemberId()+"멤버 가져오기 테스트");
        member.setMemberPw(req.getPw());
        member.setMemberName(req.getName());
        member.setMemberBday(req.getBirth());
        member.setMemberAddress(req.getAddress());
        member.setMemberTel(req.getTel());
        member.setMemberPhone(req.getPhone());
        member.setMemberEmail(req.getEmail());
        member.setMemberEmailYn(req.getEmailyn());

        mapper.updateMember(member);
    }

    @Transactional
    public void updateGoogle(RegisterRequest req) {

        Member member = mapper.selectByEmailGoogle(req.getEmail());
        System.out.println(member.getMemberEmail()+"멤버 가져오기 테스트");

        member.setMemberName(req.getName());
        member.setMemberBday(req.getBirth());
        member.setMemberAddress(req.getAddress());
        member.setMemberTel(req.getTel());
        member.setMemberPhone(req.getPhone());
        member.setMemberEmailYn(req.getEmailyn());

        mapper.updateMemberGoogle(member);
    }

    @Transactional
    public void delete(Integer memberNum) { //아직 테스트 안해봄
        mapper.deleteMember(memberNum);
    }

    @Transactional
    public void deleteGoogle(String memberEmail) { //아직 테스트 안해봄
        mapper.deleteMemberGoogle(memberEmail);
    }

    @Transactional
    public Member selectByEmailGoogle(String memberEmail) {
        Member member = mapper.selectByEmailGoogle(memberEmail);

        return member;
    }


}
