package cf.democf.controller;

import cf.democf.Main;
import cf.democf.db_connect.nv_db_cnt;
import cf.democf.model.menu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class oder_view_controller {
    private String ma_ban;

    public String getMa_ban() {
        return ma_ban;
    }

    public void setMa_ban(String ma_ban) {
        this.ma_ban = ma_ban;
    }

    private int amt;

    private String ma_mon;

    @FXML
    private TextField amount_field;

    @FXML
    private Button chon;

    @FXML
    private TableColumn<?, ?> dv_col;

    @FXML
    private ImageView find_order_img;

    @FXML
    private TableColumn<?, ?> gia_col;

    @FXML
    private TextField order_field;

    @FXML
    private TableView<menu> order_list;

    @FXML
    private TableColumn<?, ?> ten_mon_col;

    @FXML
    private Button xac_nhan_order;

    @FXML
    void find_order(MouseEvent event) {
        order_list.getItems().clear();
        order_list.setItems(nv_db_cnt.find_mon(order_field.getText()));
        ten_mon_col.setCellValueFactory(new PropertyValueFactory<>("ten_mon"));
        gia_col.setCellValueFactory(new PropertyValueFactory<>("price"));
        dv_col.setCellValueFactory(new PropertyValueFactory<>("dv"));
    }

    @FXML
    void get_amount(ActionEvent event) {
        amt=Integer.parseInt(amount_field.getText());
    }



    @FXML
    void chon(MouseEvent event) {
        menu selected = order_list.getSelectionModel().getSelectedItem();
        ma_mon=selected.getMa_mon();
    }
    @FXML
    void xac_nhan_order(MouseEvent event) throws IOException {
        //receiveData
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        String tbl_id = (String) stage.getUserData();
        //add
        String mhd = nv_db_cnt.mhd(tbl_id);
        nv_db_cnt.addOrder(mhd,ma_mon,amt);
        //back to main
        Main m =new Main();
        m.switchScene("nv-main-view.fxml");

    }

}
