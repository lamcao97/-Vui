package ptithcm.edu.vn.dovui.Module;

public class DongVatQuestion {

    public int maCH;
    public String traloiA;
    public String traloiB;
    public String traloiC;
    public String traloiD;
    public String traloi;
    public int flag;

    public DongVatQuestion(int maCH, String traloiA, String traloiB, String traloiC, String traloiD, String traloi, int plag) {
        this.maCH = maCH;
        this.traloiA = traloiA;
        this.traloiB = traloiB;
        this.traloiC = traloiC;
        this.traloiD = traloiD;
        this.traloi = traloi;
        this.flag = flag;
    }

    public int getMaCH() {
        return maCH;
    }

    public void setMaCH(int maCH) {
        this.maCH = maCH;
    }

    public String getTraloiA() {
        return traloiA;
    }

    public void setTraloiA(String traloiA) {
        this.traloiA = traloiA;
    }

    public String getTraloiB() {
        return traloiB;
    }

    public void setTraloiB(String traloiB) {
        this.traloiB = traloiB;
    }

    public String getTraloiC() {
        return traloiC;
    }

    public void setTraloiC(String traloiC) {
        this.traloiC = traloiC;
    }

    public String getTraloiD() {
        return traloiD;
    }

    public void setTraloiD(String traloiD) {
        this.traloiD = traloiD;
    }

    public String getTraloi() {
        return traloi;
    }

    public void setTraloi(String traloi) {
        this.traloi = traloi;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int Flag) {
        this.flag = Flag;
    }
}
