package team.kyp.kypcoffee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.kyp.kypcoffee.domain.Product_info;
import team.kyp.kypcoffee.mapper.ProductListMapper;

import java.util.List;

@Service
public class ProductListServiceImpl implements ProductListService {

    @Autowired
    ProductListMapper mapper;

    @Override
    public List<Product_info> findAll() {

        return mapper.selectAll();
    }

    @Override
    public List<Product_info> findType(int productType) {

        return mapper.selectType(productType);
    }

    @Override
    public Product_info detailByCode(Long productCode) {

        return mapper.selectByCode(productCode);
    }
}
