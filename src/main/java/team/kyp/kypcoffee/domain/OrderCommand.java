package team.kyp.kypcoffee.domain;

import java.util.ArrayList;

public class OrderCommand {

//    private int[] cartNum;
//
//    public int[] getCartNum() {
//        return cartNum;
//    }
//
//    public void setCartNum(int[] cartNum) {
//        this.cartNum = cartNum;
//    }

    private ArrayList<Integer> cartNum;

    public ArrayList<Integer> getCartNum() {
        return cartNum;
    }

    public void setCartNum(ArrayList<Integer> cartNum) {
        this.cartNum = cartNum;
    }
}