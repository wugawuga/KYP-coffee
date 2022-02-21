package team.kyp.kypcoffee.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.kyp.kypcoffee.domain.AuthInfo;
import team.kyp.kypcoffee.domain.Member;
import team.kyp.kypcoffee.exception.IdPasswordNotMatchingException;
import team.kyp.kypcoffee.mapper.MemberMapper;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Autowired
    MemberMapper mapper;

    public AuthInfo authenticate(String id, String name, int no, String pw) {
        System.out.println("매퍼 불러오기전");
    Member member = mapper.selectById(id);
        System.out.println("멤버정보 정상 작동"+ member.getMemberName());
    /////////////////여기서 문제
        if(member==null) {
            throw new IdPasswordNotMatchingException();
        }
        if(!member.getMemberPw().equals(pw)) {
            throw new IdPasswordNotMatchingException();
        }
        System.out.println("멤버정보 authinfo저장 전");
        return new AuthInfo(member.getMemberId(),member.getMemberName(),member.getMemberNum(),member.getMemberPw());
    }
    }
