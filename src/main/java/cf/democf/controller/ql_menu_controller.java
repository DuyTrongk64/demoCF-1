package cf.democf.controller;

import cf.democf.Main;
import cf.democf.db_connect.nv_db_cnt;
import cf.democf.model.menu;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ql_menu_controller implements Initializable{

        /**
         * Initializes the controller class.
         */
        @Override
        public void initialize(URL url, ResourceBundle rb) {
            show_menu();
        }

    @FXML
    private Button add;

    @FXML
    private TableColumn<?, ?> dv;

    @FXML
    private TextField field;

    @FXML
    private ImageView find;

    @FXML
    private TableColumn<?, ?> gia;

    @FXML
    private TableColumn<?, ?> ma_loai;

    @FXML
    private TableColumn<?, ?> ma_mon;

    @FXML
    private TableView<menu> menu_tbl;

    @FXML
    private Button sua;

    @FXML
    private TableColumn<?, ?> ten_mon;

    @FXML
    private Button xoa;

    @FXML
    void add(MouseEvent event) throws IOException {
        Main m = new Main();
        m.switchScene("add-menu.fxml");
    }

    @FXML
    void find(MouseEvent event) {
        menu_tbl.setItems(nv_db_cnt.find_mon(field.getText()));
        ma_mon.setCellValueFactory(new PropertyValueFactory<>("ma_mon"));
        ten_mon.setCellValueFactory(new PropertyValueFactory<>("ten_mon"));
        ma_loai.setCellValueFactory(new PropertyValueFactory<>("ma_loai"));
        gia.setCellValueFactory(new PropertyValueFactory<>("price"));
        dv.setCellValueFactory(new PropertyValueFactory<>("dv"));
    }

    @FXML
    void sua(MouseEvent event) {

    }

    @FXML
    void xoa(MouseEvent event) {

    }

    private void show_menu() {
        menu_tbl.setItems(nv_db_cnt.menuInf());
        ma_mon.setCellValueFactory(new PropertyValueFactory<>("ma_mon"));
        ten_mon.setCellValueFactory(new PropertyValueFactory<>("ten_mon"));
        ma_loai.setCellValueFactory(new PropertyValueFactory<>("ma_loai"));
        gia.setCellValueFactory(new PropertyValueFactory<>("price"));
        dv.setCellValueFactory(new PropertyValueFactory<>("dv"));
    }
}
