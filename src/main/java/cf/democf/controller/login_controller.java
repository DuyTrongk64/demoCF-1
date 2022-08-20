package cf.democf.controller;

import cf.democf.model.model;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class login_controller {
    model m = new model();

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
        m.checkLogin(user_field.getText(),pass_field.getText());
    }


}
