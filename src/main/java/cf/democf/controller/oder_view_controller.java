package cf.democf.controller;

import cf.democf.Main;
import cf.democf.db_connect.nv_db_cnt;
import cf.democf.model.menu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class oder_view_controller implements Initializable {
    public String ma_ban;
    public int amt;
    public String mamon;

    public void initialize(URL url, ResourceBundle rb){
        order_list.getItems().clear();
        order_list.setItems(nv_db_cnt.find_mon(order_field.getText()));
        ten_mon_col.setCellValueFactory(new PropertyValueFactory<>("ten_mon"));
        gia_col.setCellValueFactory(new PropertyValueFactory<>("price"));
        dv_col.setCellValueFactory(new PropertyValueFactory<>("dv"));
    }
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
    private TableColumn<?, ?> ma_mon;

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
        mamon=selected.getMa_mon();
        //System.out.print(mamon);
    }
    @FXML
    void xac_nhan_order(MouseEvent event) throws IOException {
        //receiveData
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        String tbl_id = (String) stage.getUserData();
        //System.out.print(tbl_id);
        //add
        amt=Integer.parseInt(amount_field.getText());

        String mhd = nv_db_cnt.mhd(tbl_id);
        nv_db_cnt.addOrder(mhd,mamon,amt);
        //back to main
        Main m =new Main();
        m.switchScene("nv-main-view.fxml");
        System.out.print(mhd);
        System.out.print(mamon);
        System.out.print(amt);

    }

}
