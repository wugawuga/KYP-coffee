package team.kyp.kypcoffee.service;

import team.kyp.kypcoffee.domain.Member;

import java.util.List;

public interface MemberService {
    List<Member> selectAllMember();
}
