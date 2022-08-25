package cf.democf.controller;

import cf.democf.db_connect.nv_db_cnt;
import cf.democf.model.nhan_vien;
import cf.democf.model.tables;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class ql_ban_controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showBan();

    }

    @FXML
    private TableView<tables> ban_tbl;

    @FXML
    private TextField field;

    @FXML
    private ImageView find;

    @FXML
    private TableColumn<?, ?> ma_ban;

    @FXML
    private Button sua;

    @FXML
    private TableColumn<?, ?> ten_ban;

    @FXML
    private TableColumn<?, ?> tt;

    @FXML
    void find(MouseEvent event) {
        ban_tbl.getItems().clear();
        ban_tbl.setItems(nv_db_cnt.findTbl(field.getText()));
        ma_ban.setCellValueFactory(new PropertyValueFactory<>("tbl_id"));
        ten_ban.setCellValueFactory(new PropertyValueFactory<>("tbl_name"));
        tt.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    @FXML
    void sua(MouseEvent event) {

    }

    private void showBan(){
        ban_tbl.getItems().clear();
        ban_tbl.setItems(nv_db_cnt.tablesList());
        ma_ban.setCellValueFactory(new PropertyValueFactory<>("tbl_id"));
        ten_ban.setCellValueFactory(new PropertyValueFactory<>("tbl_name"));
        tt.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

}
