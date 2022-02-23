package team.kyp.kypcoffee.mapper;

import org.apache.ibatis.annotations.Mapper;
import team.kyp.kypcoffee.domain.CartCommand;

@Mapper
public interface CartMapper {

    void cartAdd(CartCommand cartCommand);
}
