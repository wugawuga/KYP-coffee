package team.kyp.kypcoffee.domain;

public class AuthInfo { //세션에 로그인 정보 저장

    private String id;
    private String name;
    private int no;
    private String pw;

    public AuthInfo () {}

    public AuthInfo(String id, String name, int no, String pw) {
        this.id = id;
        this.name = name;
        this.no = no;
        this.pw = pw;
    }

    public AuthInfo(String id, String name, int no) {
        this.id = id;
        this.name = name;
        this.no = no;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
