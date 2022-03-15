package team.kyp.kypcoffee.mapper;

import org.apache.ibatis.annotations.Mapper;
import team.kyp.kypcoffee.domain.Member;
import team.kyp.kypcoffee.domain.Payment;

import java.util.List;

@Mapper
public interface PayMapper {

    void insertPay(Payment payment);

    List<Payment> selectPaymentByMemberNum(int memberNum);
}
