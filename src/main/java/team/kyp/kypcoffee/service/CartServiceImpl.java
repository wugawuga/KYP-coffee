package team.kyp.kypcoffee.service;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.kyp.kypcoffee.domain.CartCommand;
import team.kyp.kypcoffee.mapper.CartMapper;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartMapper mapper;

    @Override
    public void createCart(CartCommand cartCommand) {

        mapper.cartAdd(cartCommand);
    }
}
