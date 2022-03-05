package team.kyp.kypcoffee.domain;

import org.springframework.stereotype.Repository;

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

    public int getCartQuantity() {
        return cartQuantity;
    }

    public void setCartQuantity(int cartQuantity) {
        this.cartQuantity = cartQuantity;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getContentImgName() {
        return contentImgName;
    }

    public void setContentImgName(String contentImgName) {
        this.contentImgName = contentImgName;
    }

    private int productType;

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }

    public Product_info(int productCode, String productName, int productQuantity, int productPrice, String productImg, String productContentImg) {
        this.productCode = productCode;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
        this.productImg = productImg;
        this.productContentImg = productContentImg;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

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

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public String getProductContentImg() {
        return productContentImg;
    }

    public void setProductContentImg(String productContentImg) {
        this.productContentImg = productContentImg;
    }
}
