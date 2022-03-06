package team.kyp.kypcoffee.service;

import org.springframework.stereotype.Service;
import team.kyp.kypcoffee.domain.*;
import team.kyp.kypcoffee.mapper.AdminOnedayClassMapper;

import java.util.List;

@Service
public class AdminOnedayClassServiceImpl implements AdminOnedayClassService{

    private AdminOnedayClassMapper mapper;

    public AdminOnedayClassServiceImpl(AdminOnedayClassMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public void onedayClassOpen(OnedayClassOpenCommand onedayClassOpenCommand) {
        mapper.insertOnedayClassOpen(onedayClassOpenCommand);
    }

    @Override
    public List<OnedayClass> selectPaging(Paging paging) {
        return mapper.selectPaging(paging);
    }

    @Override
    public int selectAllNumber() {
        return mapper.selectAllNumber();
    }

    @Override
    public String totalCntJudge(int totalCnt) {
        String judge = "";
        if(totalCnt > 100) judge = "101";
        if(totalCnt == 100) judge = "100";
        if(totalCnt < 100) judge = "99";

        return judge;
    }

    @Override
    public List<OnedayClassApplierInfo> selectClassByNum(int classNum) {
        return mapper.selectClassByNum(classNum);
    }

    @Override
    public void deleteApplierByNum(OnedayDelete onedayDelete) {
        mapper.deleteApplierByNum(onedayDelete);
    }

    @Override
    public void deleteClass(int classNum) {
        mapper.deleteClass(classNum);
    }
}
