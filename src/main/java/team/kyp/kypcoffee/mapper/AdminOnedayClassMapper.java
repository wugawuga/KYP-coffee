package team.kyp.kypcoffee.mapper;

import org.apache.ibatis.annotations.Mapper;
import team.kyp.kypcoffee.domain.OnedayClassOpenCommand;

@Mapper
public interface AdminOnedayClassMapper {

    void insertOnedayClassOpen(OnedayClassOpenCommand onedayClassOpenCommand);
}
