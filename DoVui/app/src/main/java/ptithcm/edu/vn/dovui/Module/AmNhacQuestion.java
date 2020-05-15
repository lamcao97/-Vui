package ptithcm.edu.vn.dovui.Module;

public class AmNhacQuestion {
    public int maCH;
    public String cauhoi;
    public String traloi1;
    public String traloi2;
    public String traloi3;
    public String traloi4;
    public String traloidung;
    public int flag;

    public AmNhacQuestion(int maCH, String cauhoi, String traloi1, String traloi2, String traloi3, String traloi4, String traloidung, int flag) {
        this.maCH = maCH;
        this.cauhoi = cauhoi;
        this.traloi1 = traloi1;
        this.traloi2 = traloi2;
        this.traloi3 = traloi3;
        this.traloi4 = traloi4;
        this.traloidung = traloidung;
        this.flag = flag;
    }

    public int getMaCH() {
        return maCH;
    }

    public void setMaCH(int maCH) {
        this.maCH = maCH;
    }

    public String getCauhoi() {
        return cauhoi;
    }

    public void setCauhoi(String cauhoi) {
        this.cauhoi = cauhoi;
    }

    public String getTraloi1() {
        return traloi1;
    }

    public void setTraloi1(String traloi1) {
        this.traloi1 = traloi1;
    }

    public String getTraloi2() {
        return traloi2;
    }

    public void setTraloi2(String traloi2) {
        this.traloi2 = traloi2;
    }

    public String getTraloi3() {
        return traloi3;
    }

    public void setTraloi3(String traloi3) {
        this.traloi3 = traloi3;
    }

    public String getTraloi4() {
        return traloi4;
    }

    public void setTraloi4(String traloi4) {
        this.traloi4 = traloi4;
    }

    public String getTraloidung() {
        return traloidung;
    }

    public void setTraloidung(String traloidung) {
        this.traloidung = traloidung;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
