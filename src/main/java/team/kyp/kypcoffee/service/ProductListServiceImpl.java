package team.kyp.kypcoffee.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import team.kyp.kypcoffee.domain.Product_info;
import team.kyp.kypcoffee.mapper.ProductListMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductListServiceImpl implements ProductListService {

    private final ProductListMapper mapper;

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
