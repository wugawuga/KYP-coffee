package team.kyp.kypcoffee.service;

import com.sun.istack.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.kyp.kypcoffee.domain.Member;
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
    public Member selectById(String memberId) {
        Member member = mapper.selectById(memberId);

        return member;
    }

    @Transactional
    public Member selectByEmail(String memberEmail) {
        Member member = mapper.selectByEmail(memberEmail);

        return member;
    }


}
