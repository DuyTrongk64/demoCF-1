package cf.democf.model;

public class phanloai {
    private String ma_loai;
    private String ten_loai;

    public String getMa_loai() {
        return ma_loai;
    }

    public void setMa_loai(String ma_loai) {
        this.ma_loai = ma_loai;
    }

    public String getTen_loai() {
        return ten_loai;
    }

    public void setTen_loai(String ten_loai) {
        this.ten_loai = ten_loai;
    }

    public phanloai(String ten_loai) {
        this.ten_loai = ten_loai;
    }

    public phanloai(String ma_loai, String ten_loai) {
        this.ma_loai = ma_loai;
        this.ten_loai = ten_loai;
    }
}
