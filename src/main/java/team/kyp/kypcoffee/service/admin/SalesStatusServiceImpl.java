package team.kyp.kypcoffee.service.admin;

import org.springframework.stereotype.Service;
import team.kyp.kypcoffee.domain.admin.SummarySales;
import team.kyp.kypcoffee.mapper.admin.SalesStatusMapper;

import java.util.List;

@Service
public class SalesStatusServiceImpl implements SalesStatusService{

    private SalesStatusMapper mapper;

    public SalesStatusServiceImpl(SalesStatusMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public List<SummarySales> selectSummarySales(String payDate) {
        return mapper.selectSummarySales(payDate);
    }

    @Override
    public List<SummarySales> selectSummarySalesMonth(String payDate) {
        return mapper.selectSummarySalesMonth(payDate);
    }
}
