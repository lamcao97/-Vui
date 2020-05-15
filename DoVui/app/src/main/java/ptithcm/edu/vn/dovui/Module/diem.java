package ptithcm.edu.vn.dovui.Module;

public class diem {
    private int maDiem;
    private String ten;
    private int diemtoan;
    private int diemdongvat;
    private int diemamnhac;
    private int diemiq;
    private int diemthienvan;

    public diem(int maDiem, String ten, int diemtoan, int diemdongvat, int diemamnhac, int diemiq, int diemthienvan) {
        this.maDiem = maDiem;
        this.ten = ten;
        this.diemtoan = diemtoan;
        this.diemdongvat = diemdongvat;
        this.diemamnhac = diemamnhac;
        this.diemiq = diemiq;
        this.diemthienvan = diemthienvan;
    }

    public int getMaDiem() {
        return maDiem;
    }

    public void setMaDiem(int maDiem) {
        this.maDiem = maDiem;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getDiemtoan() {
        return diemtoan;
    }

    public void setDiemtoan(int diemtoan) {
        this.diemtoan = diemtoan;
    }

    public int getDiemdongvat() {
        return diemdongvat;
    }

    public void setDiemdongvat(int diemdongvat) {
        this.diemdongvat = diemdongvat;
    }

    public int getDiemamnhac() {
        return diemamnhac;
    }

    public void setDiemamnhac(int diemamnhac) {
        this.diemamnhac = diemamnhac;
    }

    public int getDiemiq() {
        return diemiq;
    }

    public void setDiemiq(int diemiq) {
        this.diemiq = diemiq;
    }

    public int getDiemthienvan() {
        return diemthienvan;
    }

    public void setDiemthienvan(int diemthienvan) {
        this.diemthienvan = diemthienvan;
    }
}
