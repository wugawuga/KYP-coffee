package team.kyp.kypcoffee.mapper;

import org.apache.ibatis.annotations.Mapper;
import team.kyp.kypcoffee.domain.Product_info;

import java.util.List;

@Mapper
public interface ProductListMapper {

    List<Product_info> selectAll();

    List<Product_info> selectType(int productType);

    Product_info selectByCode(Long productCode);
}
