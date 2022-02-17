package team.kyp.kypcoffee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.kyp.kypcoffee.domain.Member;
import team.kyp.kypcoffee.mapper.MemberMapper;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    MemberMapper mapper;

    @Override
    public List<Member> selectAllMember() {
        return mapper.selectAll();
    }
}
