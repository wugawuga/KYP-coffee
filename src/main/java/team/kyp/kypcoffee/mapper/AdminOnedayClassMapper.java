package team.kyp.kypcoffee.mapper;

import org.apache.ibatis.annotations.Mapper;
import team.kyp.kypcoffee.domain.*;

import java.util.List;

@Mapper
public interface AdminOnedayClassMapper {

    void insertOnedayClassOpen(OnedayClassOpenCommand onedayClassOpenCommand);

    List<OnedayClass> selectPaging(Paging paging);

    int selectAllNumber();

    List<OnedayClassApplierInfo> selectClassByNum(int classNum);

    void deleteApplierByNum(OnedayDelete onedayDelete);

    void deleteClass(int classNum);

}
