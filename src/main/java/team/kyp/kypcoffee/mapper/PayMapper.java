package team.kyp.kypcoffee.mapper;

import org.apache.ibatis.annotations.Mapper;
import team.kyp.kypcoffee.domain.Member;
import team.kyp.kypcoffee.domain.Payment;

@Mapper
public interface PayMapper {

    void insertPay(Payment payment);
}
