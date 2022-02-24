package team.kyp.kypcoffee.domain;

import lombok.Data;

import java.util.Date;

@Data
public class QnaBoard {
    private int qnaBoardNum;
    private int memberNum;
    private String qnaBoardTitle;
    private String qnaBoardContent;
    private Date qnaBoardDate;

}
