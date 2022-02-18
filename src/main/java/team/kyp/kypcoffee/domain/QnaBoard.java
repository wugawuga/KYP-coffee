package team.kyp.kypcoffee.domain;

import java.util.Date;

public class QnaBoard {
    private int qnaBoardNum;
    private int memberNum;
    private String qnaBoardTitle;
    private String qnaBoardContent;
    private Date qnaBoardDate;

    public QnaBoard(int qnaBoardNum, int memberNum, String qnaBoardTitle, String qnaBoardContent, Date qnaBoardDate) {
        this.qnaBoardNum = qnaBoardNum;
        this.memberNum = memberNum;
        this.qnaBoardTitle = qnaBoardTitle;
        this.qnaBoardContent = qnaBoardContent;
        this.qnaBoardDate = qnaBoardDate;
    }

    public QnaBoard() {}

    public int getQnaBoardNum() {
        return qnaBoardNum;
    }

    public void setQnaBoardNum(int qnaBoardNum) {
        this.qnaBoardNum = qnaBoardNum;
    }

    public int getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(int memberNum) {
        this.memberNum = memberNum;
    }

    public String getQnaBoardTitle() {
        return qnaBoardTitle;
    }

    public void setQnaBoardTitle(String qnaBoardTitle) {
        this.qnaBoardTitle = qnaBoardTitle;
    }

    public String getQnaBoardContent() {
        return qnaBoardContent;
    }

    public void setQnaBoardContent(String qnaBoardContent) {
        this.qnaBoardContent = qnaBoardContent;
    }

    public Date getQnaBoardDate() {
        return qnaBoardDate;
    }

    public void setQnaBoardDate(Date qnaBoardDate) {
        this.qnaBoardDate = qnaBoardDate;
    }
}
