package team.kyp.kypcoffee.service;

import team.kyp.kypcoffee.domain.Notice;
import team.kyp.kypcoffee.domain.Paging;

import java.util.List;

public interface NoticeService {
    List<Notice> selectAllNotice();

    List<Notice> selectPaging(Paging paging);

    int selectAllNumber();

    String totalCntJudge(int totalCnt);
}
