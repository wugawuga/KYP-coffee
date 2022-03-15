package team.kyp.kypcoffee.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Payment {

    private int payCode;
    private int payNumber;
    private int productCode;
    private int cartQuantity;
    private int price;
    private String imp_uid;
    private String payStatus;
    private Date payDate;
    private int memberNum;
    private String payDateString;

    public Payment(int productCode, int cartQuantity, int price, String imp_uid, Date payDate, int memberNum) {
        this.productCode = productCode;
        this.cartQuantity = cartQuantity;
        this.price = price;
        this.imp_uid = imp_uid;
        this.payDate = payDate;
        this.memberNum = memberNum;
    }

    public Payment(int payNumber, int productCode, int cartQuantity, String payStatus) {
        this.payNumber = payNumber;
        this.productCode = productCode;
        this.cartQuantity = cartQuantity;
        this.payStatus = payStatus;
    }
}
