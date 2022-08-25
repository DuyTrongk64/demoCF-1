package cf.democf.model;

public class ban {
    private String ten_mon;
    private int amount;
    private int price;
    private int pay;

    public ban(String ten_mon, int amount, int price, int pay) {
        this.ten_mon = ten_mon;
        this.amount = amount;
        this.price = price;
        this.pay = pay;
    }

    public String getTen_mon() {
        return ten_mon;
    }

    public void setTen_mon(String ten_mon) {
        this.ten_mon = ten_mon;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }
}
