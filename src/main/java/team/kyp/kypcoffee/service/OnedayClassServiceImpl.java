package team.kyp.kypcoffee.service;

import org.springframework.stereotype.Service;
import team.kyp.kypcoffee.domain.OnedayClass;
import team.kyp.kypcoffee.domain.OnedayClassNum;
import team.kyp.kypcoffee.mapper.OnedayClassMapper;

import java.util.List;

@Service
public class OnedayClassServiceImpl implements OnedayClassService{

    private OnedayClassMapper mapper;

    public OnedayClassServiceImpl(OnedayClassMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public List<OnedayClassNum> selectOpenClass() {
        return mapper.selectOpenClass();
    }
}
