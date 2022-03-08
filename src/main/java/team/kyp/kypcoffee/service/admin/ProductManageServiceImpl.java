package team.kyp.kypcoffee.service.admin;

import org.springframework.stereotype.Service;
import team.kyp.kypcoffee.domain.Paging;
import team.kyp.kypcoffee.domain.admin.ProductManage;
import team.kyp.kypcoffee.mapper.admin.ProductManageMapper;

import java.util.List;

@Service
public class ProductManageServiceImpl implements ProductManageService{

    private ProductManageMapper mapper;

    public ProductManageServiceImpl(ProductManageMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<ProductManage> selectProductList(Paging paging) {
        return mapper.selectProductList(paging);
    }

    @Override
    public int selectAllCnt() {
        return mapper.selectAllCnt();
    }

    @Override
    public String totalCntJudge(int totalCnt) {
        String judge = "";
        if(totalCnt > 100) judge = "101";
        if(totalCnt == 100) judge = "100";
        if(totalCnt < 100) judge = "99";

        return judge;
    }

}
