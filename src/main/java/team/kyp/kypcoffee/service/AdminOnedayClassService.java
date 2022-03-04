package team.kyp.kypcoffee.service;

import team.kyp.kypcoffee.domain.*;

import java.util.List;

public interface AdminOnedayClassService {

    void onedayClassOpen(OnedayClassOpenCommand onedayClassOpenCommand);

    List<OnedayClass> selectPaging(Paging paging);

    int selectAllNumber();

    String totalCntJudge(int totalCnt);

    List<OnedayClassApplierInfo> selectClassByNum(int classNum);

    void deleteApplierByNum(OnedayDelete onedayDelete);






}
