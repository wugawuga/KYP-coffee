package team.kyp.kypcoffee.service;

import team.kyp.kypcoffee.domain.Member;

import java.util.List;

public interface NoticeService {
    List<Member> selectAllNotice();
    void insertNotice();
    void updateNotice();
    void deleteNotice();
}
