package team.kyp.kypcoffee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.kyp.kypcoffee.domain.Notice;
import team.kyp.kypcoffee.mapper.NoticeMapper;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService{

    @Autowired
    NoticeMapper mapper;

    @Override
    public List<Notice> selectAllNotice() {
        return mapper.selectAll();
    }

}
