package cf.democf.model;

public class menu {
    private String ma_mon;
    private String ten_mon;
    private String ma_loai;
    private int price;
    private String dv;

    public String getMa_mon() {
        return ma_mon;
    }

    public void setMa_mon(String ma_mon) {
        this.ma_mon = ma_mon;
    }

    public String getTen_mon() {
        return ten_mon;
    }

    public void setTen_mon(String ten_mon) {
        this.ten_mon = ten_mon;
    }

    public String getMa_loai() {
        return ma_loai;
    }

    public void setMa_loai(String ma_loai) {
        this.ma_loai = ma_loai;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public menu(String ma_mon) {
        this.ma_mon = ma_mon;
    }

    public menu(String ma_mon, String ten_mon) {
        this.ma_mon = ma_mon;
        this.ten_mon = ten_mon;
    }

    public menu(String ma_mon, String ten_mon, String ma_loai) {
        this.ma_mon = ma_mon;
        this.ten_mon = ten_mon;
        this.ma_loai = ma_loai;
    }

    public menu(String ma_mon, String ten_mon, String ma_loai, int price) {
        this.ma_mon = ma_mon;
        this.ten_mon = ten_mon;
        this.ma_loai = ma_loai;
        this.price = price;
    }

    public menu(String ma_mon, String ten_mon, String ma_loai, int price, String dv) {
        this.ma_mon = ma_mon;
        this.ten_mon = ten_mon;
        this.ma_loai = ma_loai;
        this.price = price;
        this.dv = dv;
    }

    public menu(String ten_mon, int price, String dv) {
        this.ten_mon = ten_mon;
        this.price = price;
        this.dv = dv;
    }

    public menu(String ma_mon, String ten_mon, int price, String dv) {
        this.ma_mon = ma_mon;
        this.ten_mon = ten_mon;
        this.price = price;
        this.dv = dv;
    }
}
