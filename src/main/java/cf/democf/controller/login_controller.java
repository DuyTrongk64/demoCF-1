package cf.democf.controller;

import cf.democf.Main;
import cf.democf.db_connect.nv_db_cnt;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class login_controller {


    @FXML
    private ImageView cf_logo;

    @FXML
    private ImageView login_img;

    @FXML
    private Label login_lab;

    @FXML
    private PasswordField pass_field;

    @FXML
    private Label pass_lab;

    @FXML
    private TextField user_field;

    @FXML
    private Label user_lab;

    @FXML
    void login_click(MouseEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Main m = new Main();
        boolean chk= nv_db_cnt.findUser(user_field.getText(),pass_field.getText());
        if(chk){
            //m.switchSC("nv-main-view.fxml",node,user_field.getText());
            //send data
            m.sendNv_id("nv-main-view.fxml",node,user_field.getText());
        }
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Cofirmation");
            alert.setHeaderText("Dang nhap that bai");
            alert.show();
        }
    }


}
