package cf.democf.controller;

import cf.democf.db_connect.nv_db_cnt;
import cf.democf.model.nhan_vien;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class tt_nv_controller implements Initializable {
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        shownv();
    }


    @FXML
    private Label adr;

    @FXML
    private Label age;

    @FXML
    private Label cccd;

    @FXML
    private Label gt;

    @FXML
    private Label mail;

    @FXML
    private Label sdt;

    @FXML
    private Label ten;

    private void shownv(){

        ten.setText("Nguyen Duy Trong");
        cccd.setText("0215991678");
        age.setText("21");
        gt.setText("Nam");
        sdt.setText("0817226323");
        mail.setText("abcd01@gmail.com");
        adr.setText("ba dinh");
    }


}
