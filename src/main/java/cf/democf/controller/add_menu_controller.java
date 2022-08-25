package cf.democf.controller;

import cf.democf.Main;
import cf.democf.db_connect.nv_db_cnt;
import cf.democf.model.menu;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class add_menu_controller {

    @FXML
    private Button cancel;

    @FXML
    private TextField dv;

    @FXML
    private TextField id;

    @FXML
    private TextField ml;

    @FXML
    private TextField name;

    @FXML
    private TextField price;

    @FXML
    private Button summ;

    @FXML
    void cal(MouseEvent event) throws IOException {
        Main m = new Main();
        m.switchScene("nv-main-view.fxml");
    }

    @FXML
    void summ(MouseEvent event) throws IOException {
        int gia = Integer.parseInt(price.getText());
        menu m = new menu(id.getText(),name.getText(),ml.getText(),gia,dv.getText());
        nv_db_cnt.insertMenu(m);
        Main a = new Main();
        a.switchScene("nv-main-view.fxml");
    }

}
