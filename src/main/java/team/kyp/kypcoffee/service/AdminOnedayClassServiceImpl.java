package team.kyp.kypcoffee.service;

import org.springframework.stereotype.Service;
import team.kyp.kypcoffee.domain.OnedayClassOpenCommand;
import team.kyp.kypcoffee.mapper.AdminOnedayClassMapper;

@Service
public class AdminOnedayClassServiceImpl implements AdminOnedayClassService{

    private AdminOnedayClassMapper mapper;

    public AdminOnedayClassServiceImpl(AdminOnedayClassMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public void onedayClassOpen(OnedayClassOpenCommand onedayClassOpenCommand) {
        mapper.insertOnedayClassOpen(onedayClassOpenCommand);
    }
}
