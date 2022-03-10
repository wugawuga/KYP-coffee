package team.kyp.kypcoffee.service.admin;

import team.kyp.kypcoffee.domain.Paging;
import team.kyp.kypcoffee.domain.admin.ProductManage;

import java.util.List;

public interface ProductManageService {

    List<ProductManage> selectProductList(Paging paging);
    int selectAllCnt();
    String totalCntJudge(int totalCnt);

}