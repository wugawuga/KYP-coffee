package team.kyp.kypcoffee.mapper.admin;

import org.apache.ibatis.annotations.Mapper;
import team.kyp.kypcoffee.domain.Paging;
import team.kyp.kypcoffee.domain.admin.ProductManage;

import java.util.List;

@Mapper
public interface ProductManageMapper {

    List<ProductManage> selectProductList(Paging paging);
    int selectAllCnt();
}
