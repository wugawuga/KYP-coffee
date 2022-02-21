package team.kyp.kypcoffee.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.kyp.kypcoffee.domain.Member;
import team.kyp.kypcoffee.domain.RegisterRequest;
import team.kyp.kypcoffee.mapper.MemberMapper;

@Service
@RequiredArgsConstructor
public class MemberRegisterService {

    @Autowired
    MemberMapper mapper;

    @Transactional
    public void register(RegisterRequest req){

        System.out.println("서비스까지 실행됨"+req.getName());

        Member newMember = new Member(req.getNo(), req.getId(), req.getPw(), req.getName(),req.getBirth(),req.getAddress(),
                req.getTel(), req.getPhone(),req.getEmail(), req.getEmailyn(),req.getPoint(),req.getType());

        mapper.insertMember(newMember);



    }


}
