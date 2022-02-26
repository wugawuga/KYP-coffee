package team.kyp.kypcoffee.service;

import team.kyp.kypcoffee.domain.Cart;
import team.kyp.kypcoffee.domain.CartCommand;

import java.util.List;

public interface CartService {

    void createCart(CartCommand cartCommand);

    List<Cart> findAll(int memberNum);
}
