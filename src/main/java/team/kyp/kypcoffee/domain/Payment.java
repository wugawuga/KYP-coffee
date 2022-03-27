package team.kyp.kypcoffee.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Payment {

    private int groupNumber;
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
    private String productName;
    private int mileage;

    public Payment(int productCode, int cartQuantity, int price, String imp_uid, Date payDate, int memberNum, int mileage) {
        this.productCode = productCode;
        this.cartQuantity = cartQuantity;
        this.price = price;
        this.imp_uid = imp_uid;
        this.payDate = payDate;
        this.memberNum = memberNum;
        this.mileage = mileage;
    }

    public Payment(int groupNumber, int payCode, int payNumber, int productCode, int cartQuantity, int price, String payStatus, String imp_uid, Date payDate, int memberNum, String productName) {
        this.groupNumber = groupNumber;
        this.payCode = payCode;
        this.payNumber = payNumber;
        this.productCode = productCode;
        this.cartQuantity = cartQuantity;
        this.price = price;
        this.imp_uid = imp_uid;
        this.payStatus = payStatus;
        this.payDate = payDate;
        this.memberNum = memberNum;
        this.payDateString = payDateString;
        this.productName = productName;
    }
}
