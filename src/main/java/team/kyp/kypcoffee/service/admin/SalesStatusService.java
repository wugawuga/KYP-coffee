package team.kyp.kypcoffee.service.admin;

import team.kyp.kypcoffee.domain.admin.SummarySales;

import java.util.List;

public interface SalesStatusService {
    List<SummarySales> selectSummarySales(String payDate);
    List<SummarySales> selectSummarySalesMonth(String payDate);
}
