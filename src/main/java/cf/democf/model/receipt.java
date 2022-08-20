package cf.democf.model;

import java.sql.Timestamp;

public class receipt {
    private String receipt_id;
    private int sale;
    private String tbl_id;
    private Timestamp datetime;
    private int sum;

    public receipt(String receipt_id, int sale, String tbl_id, Timestamp datetime, int sum) {
        this.receipt_id = receipt_id;
        this.sale = sale;
        this.tbl_id = tbl_id;
        this.datetime = datetime;
        this.sum = sum;
    }

    public receipt(String receipt_id, int sale, String tbl_id) {
        this.receipt_id = receipt_id;
        this.sale = sale;
        this.tbl_id = tbl_id;
    }

    public receipt(String receipt_id, String tbl_id, Timestamp datetime) {
        this.receipt_id = receipt_id;
        this.tbl_id = tbl_id;
        this.datetime = datetime;
    }

    public receipt(String receipt_id, int sale, String tbl_id, Timestamp datetime) {
        this.receipt_id = receipt_id;
        this.sale = sale;
        this.tbl_id = tbl_id;
        this.datetime = datetime;
    }

    public String getReceipt_id() {
        return receipt_id;
    }

    public void setReceipt_id(String receipt_id) {
        this.receipt_id = receipt_id;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public String getTbl_id() {
        return tbl_id;
    }

    public void setTbl_id(String tbl_id) {
        this.tbl_id = tbl_id;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
