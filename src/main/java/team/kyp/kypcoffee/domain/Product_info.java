package team.kyp.kypcoffee.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

@Getter
@Setter
public class Product_info {

    private int productCode;
    private String productName;
    private int productQuantity;
    private int productPrice;
    private String productImg;
    private String productContentImg;
    private String imgName;
    private String contentImgName;
    private int cartQuantity;

    private String productType;

    public Product_info(int productCode, String productName, int productQuantity, int productPrice, String productImg, String productContentImg) {
        this.productCode = productCode;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
        this.productImg = productImg;
        this.productContentImg = productContentImg;
    }

}
