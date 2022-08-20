package cf.democf.model;

public class tables {
    private String tbl_id;
    private String tbl_name;
    private boolean status;

    public String getTbl_id() {
        return tbl_id;
    }

    public void setTbl_id(String tbl_id) {
        this.tbl_id = tbl_id;
    }

    public String getTbl_name() {
        return tbl_name;
    }

    public void setTbl_name(String tbl_name) {
        this.tbl_name = tbl_name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public tables(String tbl_id) {
        this.tbl_id = tbl_id;
    }

    public tables(String tbl_id, String tbl_name) {
        this.tbl_id = tbl_id;
        this.tbl_name = tbl_name;
    }

    public tables(String tbl_id, String tbl_name, boolean status) {
        this.tbl_id = tbl_id;
        this.tbl_name = tbl_name;
        this.status = status;
    }
}
