package team.kyp.kypcoffee.domain;

import org.springframework.web.multipart.MultipartFile;

public class AdminProductRegiCommand {
    private String productName;
    private int productQuantity;
    private int productPrice;
    private MultipartFile productImg;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public MultipartFile getProductImg() {
        return productImg;
    }

    public void setProductImg(MultipartFile productImg) {
        this.productImg = productImg;
    }
}