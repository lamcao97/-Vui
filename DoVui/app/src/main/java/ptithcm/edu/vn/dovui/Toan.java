package ptithcm.edu.vn.dovui;

public class Toan {
    private String dapancuaban;
    private String dapandung;

    public Toan(String dapancuaban, String dapandung) {
        this.dapancuaban = dapancuaban;
        this.dapandung = dapandung;
    }

    public String getDapancuaban() {
        return dapancuaban;
    }

    public void setDapancuaban(String dapancuaban) {
        this.dapancuaban = dapancuaban;
    }

    public String getDapandung() {
        return dapandung;
    }

    public void setDapandung(String dapandung) {
        this.dapandung = dapandung;
    }
}
