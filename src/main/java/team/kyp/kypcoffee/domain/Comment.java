package team.kyp.kypcoffee.domain;

import java.util.Date;

public class Comment {
    private int cmtNum;
    private int qnaBoardNum;
    private String cmtContent;
    private Date cmtDate;

    public Comment(int cmtNum, int qnaBoardNum, String cmtContent, Date cmtDate) {
        this.cmtNum = cmtNum;
        this.qnaBoardNum = qnaBoardNum;
        this.cmtContent = cmtContent;
        this.cmtDate = cmtDate;
    }

    public Comment() {}

    public int getCmtNum() {
        return cmtNum;
    }

    public void setCmtNum(int cmtNum) {
        this.cmtNum = cmtNum;
    }

    public int getQnaBoardNum() {
        return qnaBoardNum;
    }

    public void setQnaBoardNum(int qnaBoardNum) {
        this.qnaBoardNum = qnaBoardNum;
    }

    public String getCmtContent() {
        return cmtContent;
    }

    public void setCmtContent(String cmtContent) {
        this.cmtContent = cmtContent;
    }

    public Date getCmtDate() {
        return cmtDate;
    }

    public void setCmtDate(Date cmtDate) {
        this.cmtDate = cmtDate;
    }
}
