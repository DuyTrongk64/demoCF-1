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

import static cf.democf.db_connect.nv_db_cnt.getNv_Inf;

public class tt_nv_controller implements Initializable {
    /**
     * Initializes the controller class.
     */
    String user_name;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        reload();
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
    private Button rl_btn;

    @FXML
    private Label sdt;

    @FXML
    private Label ten;

    @FXML
    void reload_act(MouseEvent event) {
        //receiveData
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        user_name = (String) stage.getUserData();
        nhan_vien nv = getNv_Inf(user_name);
        ten.setText(nv.getNv_name());
        cccd.setText(nv.getCccd());
        age.setText(Integer.toString(nv.getAge()));
        sdt.setText(nv.getPhone_num());
        mail.setText(nv.getMail());
        if(nv.isGender()==true){
            gt.setText("Nam");
        }
        else gt.setText("Nũ");
        adr.setText(nv.getAddress());
    }

    private void reload(){
        rl_btn.fire();
    }

}
