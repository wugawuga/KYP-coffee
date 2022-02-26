package team.kyp.kypcoffee.mapper;

import org.apache.ibatis.annotations.Mapper;
import team.kyp.kypcoffee.domain.Cart;
import team.kyp.kypcoffee.domain.CartCommand;

import java.util.List;

@Mapper
public interface CartMapper {

    void cartAdd(CartCommand cartCommand);

    List<Cart> findAll(int memberNum);
}
