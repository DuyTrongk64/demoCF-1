package cf.democf.model;

public class nhan_vien {
    private String nv_id, nv_name, cccd;
    private int age;
    private boolean gender;
    private String phone_num;
    private String mail;
    private String address;
    private String user_name;
    private String pass_word;
    private boolean phan_quyen;

    public nhan_vien(String nv_id, String nv_name, String cccd, int age, boolean gender, String phone_num, String mail, String address, String user_name, String pass_word, boolean phan_quyen) {
        this.nv_id = nv_id;
        this.nv_name = nv_name;
        this.cccd = cccd;
        this.age = age;
        this.gender = gender;
        this.phone_num = phone_num;
        this.mail = mail;
        this.address = address;
        this.user_name = user_name;
        this.pass_word = pass_word;
        this.phan_quyen = phan_quyen;
    }

    public nhan_vien(String user_name, String pass_word) {
        this.user_name = user_name;
        this.pass_word = pass_word;
    }

    public nhan_vien(String nv_id, String nv_name, String cccd, int age, boolean gender, String phone_num, String mail, String address, String user_name, String pass_word) {
        this.nv_id = nv_id;
        this.nv_name = nv_name;
        this.cccd = cccd;
        this.age = age;
        this.gender = gender;
        this.phone_num = phone_num;
        this.mail = mail;
        this.address = address;
        this.user_name = user_name;
        this.pass_word = pass_word;
    }

    public String getNv_id() {
        return nv_id;
    }

    public void setNv_id(String nv_id) {
        this.nv_id = nv_id;
    }

    public String getNv_name() {
        return nv_name;
    }

    public void setNv_name(String nv_name) {
        this.nv_name = nv_name;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPass_word() {
        return pass_word;
    }

    public void setPass_word(String pass_word) {
        this.pass_word = pass_word;
    }

    public boolean isPhan_quyen() {
        return phan_quyen;
    }

    public void setPhan_quyen(boolean phan_quyen) {
        this.phan_quyen = phan_quyen;
    }

    public nhan_vien() {
    }

    public nhan_vien(String nv_name, String cccd, int age, boolean gender, String phone_num, String mail, String address) {
        this.nv_name = nv_name;
        this.cccd = cccd;
        this.age = age;
        this.gender = gender;
        this.phone_num = phone_num;
        this.mail = mail;
        this.address = address;
    }
}