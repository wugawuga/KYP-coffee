package team.kyp.kypcoffee.mapper.admin;

import org.apache.ibatis.annotations.Mapper;
import team.kyp.kypcoffee.domain.MileageRefund;
import team.kyp.kypcoffee.domain.Paging;
import team.kyp.kypcoffee.domain.PayInfoCount;
import team.kyp.kypcoffee.domain.Payment;

import java.util.List;

@Mapper
public interface OrdersManageMapper {
    List<Payment> selectPaymentList(Paging paging);
    List<PayInfoCount> selectPayCount();
    int selectAllNumber();

    List<Payment> selectPaymentByPayNumber(int payNumber);
    void updatePaymentByPayNumber(int payNumber);

    String selectImpuidByPayNumber(int payNumber);
    int selectPriceByPaynumber(int payNumber);

    void updateMileageForRefund(MileageRefund mileageRefund);

    int selectMemberNumByPayNumber(int payNumber);
}
