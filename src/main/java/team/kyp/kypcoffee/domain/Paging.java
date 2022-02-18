package team.kyp.kypcoffee.domain;

public class Paging {

    public Paging() {}



    public Paging(int section, int pageNum) {
        this.section = section;
        this.pageNum = pageNum;
    }



    private int section, pageNum;

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

}