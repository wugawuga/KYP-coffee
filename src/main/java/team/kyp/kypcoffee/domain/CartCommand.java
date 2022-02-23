package team.kyp.kypcoffee.domain;

public class CartCommand {

    private int cartNum;
    private int memberNum;
    private int productCode;
    private int cartQuantity;

    public CartCommand(int cartNum, int memberNum, int productCode, int cartQuantity) {
        this.cartNum = cartNum;
        this.memberNum = memberNum;
        this.productCode = productCode;
        this.cartQuantity = cartQuantity;
    }

    public int getCartNum() {
        return cartNum;
    }

    public void setCartNum(int cartNum) {
        this.cartNum = cartNum;
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
