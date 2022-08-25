package cf.democf.controller;

import cf.democf.Main;
import cf.democf.db_connect.nv_db_cnt;
import cf.democf.model.nhan_vien;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class sua_nv_controller {

    @FXML
    private RadioButton admin;

    @FXML
    private TextField age;

    @FXML
    private Button cancel;

    @FXML
    private TextField cccd;

    @FXML
    private TextField dc;

    @FXML
    private TextField id;

    @FXML
    private Button load;

    @FXML
    private TextField mail;

    @FXML
    private RadioButton nam;

    @FXML
    private TextField name;

    @FXML
    private RadioButton nu;

    @FXML
    private TextField pass;

    @FXML
    private TextField sdt;

    @FXML
    private Button summ;

    @FXML
    private TextField usn;

    @FXML
    void cal(MouseEvent event) throws IOException {
        Main m = new Main();
        m.switchScene("nv-main-view.fxml");
    }

    @FXML
    void load(MouseEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        nhan_vien nv =(nhan_vien) stage.getUserData();
        id.setText(nv.getNv_id());
        name.setText(nv.getNv_name());
        cccd.setText(nv.getCccd());
        age.setText(Integer.toString(nv.getAge()));
        if(nv.isGender()) nam.setSelected(true);
        else nu.setSelected(true);
        sdt.setText(nv.getPhone_num());
        mail.setText(nv.getMail());
        dc.setText(nv.getAddress());
        usn.setText(nv.getUser_name());
        pass.setText(nv.getPass_word());
        if(nv.isPhan_quyen()) admin.setSelected(true);
    }

    @FXML
    void summ(MouseEvent event) throws IOException {
        boolean gender = false;
        boolean phan_quyen;
        if(nu.isSelected()) gender =false;
        if(nam.isSelected()) gender = true;
        int tuoi=Integer.parseInt(age.getText());
        if(admin.isSelected()) phan_quyen = true;
        else phan_quyen = false;
        nhan_vien nv =new nhan_vien(id.getText(),name.getText(),cccd.getText(),tuoi,gender,sdt.getText(),mail.getText(),dc.getText(),usn.getText(),pass.getText(),phan_quyen);
        nv_db_cnt.insert(nv);
        Main m = new Main();
        m.switchScene("nv-main-view.fxml");
    }

}
