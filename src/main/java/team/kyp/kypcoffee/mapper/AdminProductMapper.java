package team.kyp.kypcoffee.mapper;

import org.apache.ibatis.annotations.Mapper;
import team.kyp.kypcoffee.domain.AdminProductRegiCommand;


import java.util.List;

@Mapper
public interface AdminProductMapper {

    void insertAdminProduct(AdminProductRegiCommand adminProductRegiCommand);

}
