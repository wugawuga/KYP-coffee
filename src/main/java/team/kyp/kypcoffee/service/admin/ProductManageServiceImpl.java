package team.kyp.kypcoffee.service.admin;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
        if(totalCnt > 80) judge = "81";
        if(totalCnt == 80) judge = "80";
        if(totalCnt < 80) judge = "79";

        return judge;
    }

    @Override
    public List<ProductManage> selectProductDetail(int productCode) {
        return mapper.selectProductDetail(productCode);
    }

    @Override
    @Transactional
    public void selectProductDelete(int productCode) {
        mapper.delProductByCode(productCode);
        mapper.delProductInfoByCode(productCode);
        // 사진삭제기능도 추후에 추가하기
    }

}
