package team.kyp.kypcoffee.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.kyp.kypcoffee.domain.Comment;
import team.kyp.kypcoffee.domain.CommentWrite;
import team.kyp.kypcoffee.domain.QnaBoard;
import team.kyp.kypcoffee.domain.QnaBoardWrite;
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
    @Transactional
    public QnaBoard selectView(Integer qnaBoardNum) {
        QnaBoard view = qnaBoardMapper.selectView(qnaBoardNum);
        return view;
    }

    @Transactional
    public void boardWrite(QnaBoardWrite br) {
        QnaBoard newboard = new QnaBoard(0, br.getMno(), br.getTitle(), br.getContent(), null);
        qnaBoardMapper.insertBoard(newboard);
    }
    @Transactional
    public void boardDelete(Integer qnaBoardNum) {
        qnaBoardMapper.deleteBoard(qnaBoardNum);
    }

    @Transactional
    public void boardEdit(QnaBoardWrite br) {

        QnaBoard board = qnaBoardMapper.selectView(br.getBno());
        board.setQnaBoardTitle(br.getTitle());
        board.setQnaBoardContent(br.getContent());

        qnaBoardMapper.updateBoard(board);
    }

    @Transactional
    public List<Comment> cmtList(Integer qnaBoardNum) {
       List<Comment> cmt = qnaBoardMapper.selectByNum(qnaBoardNum);
       return cmt;
    }

    @Transactional
    public void cmtWrite(CommentWrite cmtWrite) {
        Comment cmt = new Comment(0, cmtWrite.getContent(),null,cmtWrite.getBno());
        qnaBoardMapper.insertCmt(cmt);
    }

    @Transactional
    public void cmtDelete(Integer cmtNum) { qnaBoardMapper.deleteCmt(cmtNum); }


}
