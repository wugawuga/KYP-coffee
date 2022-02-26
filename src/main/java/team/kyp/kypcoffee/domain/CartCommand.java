package team.kyp.kypcoffee.domain;

public class CartCommand {

    private int memberNum;
    private int productCode;
    private int cartQuantity;

    public CartCommand(int memberNum, int productCode, int cartQuantity) {
        this.memberNum = memberNum;
        this.productCode = productCode;
        this.cartQuantity = cartQuantity;
    }

    public int getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(int memberNum) {
        this.memberNum = memberNum;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public int getCartQuantity() {
        return cartQuantity;
    }

    public void setCartQuantity(int cartQuantity) {
        this.cartQuantity = cartQuantity;
    }
}
