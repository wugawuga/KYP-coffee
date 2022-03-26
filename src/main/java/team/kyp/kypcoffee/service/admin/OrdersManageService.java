package team.kyp.kypcoffee.service.admin;

import team.kyp.kypcoffee.domain.Paging;
import team.kyp.kypcoffee.domain.PayInfoCount;
import team.kyp.kypcoffee.domain.Payment;

import java.util.List;

public interface OrdersManageService {
    List<Payment> selectPaymentList(Paging paging);

    List<PayInfoCount> selectPayCount();

    int selectAllNumber();

    String totalCntJudge(int totalCnt);

    List<Payment> selectPaymentByPayNumber(int payNumber);

    void refundPaymentByPayNumber(int payNumber);

}
