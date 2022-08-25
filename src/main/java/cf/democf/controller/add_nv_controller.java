package cf.democf.controller;

import cf.democf.Main;
import cf.democf.db_connect.nv_db_cnt;
import cf.democf.model.nhan_vien;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class add_nv_controller {

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
