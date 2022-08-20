package cf.democf.model;

public class receipt_infor {
    private String receipt_id;
    private String ma_mon;
    private int amount;
    private int pay;

    public receipt_infor(String receipt_id, String ma_mon, int amount, int pay) {
        this.receipt_id = receipt_id;
        this.ma_mon = ma_mon;
        this.amount = amount;
        this.pay = pay;
    }

    public receipt_infor(String receipt_id, String ma_mon, int amount) {
        this.receipt_id = receipt_id;
        this.ma_mon = ma_mon;
        this.amount = amount;
    }

    public String getReceipt_id() {
        return receipt_id;
    }

    public void setReceipt_id(String receipt_id) {
        this.receipt_id = receipt_id;
    }

    public String getMa_mon() {
        return ma_mon;
    }

    public void setMa_mon(String ma_mon) {
        this.ma_mon = ma_mon;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }
}
