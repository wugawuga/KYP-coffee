package team.kyp.kypcoffee.domain;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class QnaBoardWrite {
    private String title;
    private String content;
    private int mno;
    private int cno;
    private int bno;
    Timestamp cmtdate;

}
