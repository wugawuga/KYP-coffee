package team.kyp.kypcoffee.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.kyp.kypcoffee.domain.Member;
import team.kyp.kypcoffee.domain.QnaBoard;
import team.kyp.kypcoffee.mapper.QnaBoardMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QnaBoardService {

    @Autowired
    QnaBoardMapper qnaBoardMapper;

    @Transactional
    public List<QnaBoard> selectAllList() { //리스트로 출력시
        List<QnaBoard> list = qnaBoardMapper.selectAllList();
        return list;
    }

}
