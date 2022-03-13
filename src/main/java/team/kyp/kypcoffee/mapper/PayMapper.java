package team.kyp.kypcoffee.mapper;

import org.apache.ibatis.annotations.Mapper;
import team.kyp.kypcoffee.domain.Member;

@Mapper
public interface PayMapper {

    void insertPay();
}
