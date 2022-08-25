package cf.democf.controller;

import cf.democf.Main;
import cf.democf.db_connect.nv_db_cnt;
import cf.democf.model.ban;
import cf.democf.model.menu;
import cf.democf.model.nhan_vien;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class nv_main_controller implements Initializable {
    private String user;
    private String tbl_id;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTbl_id() {
        return tbl_id;
    }

    public void setTbl_id(String tbl_id) {
        this.tbl_id = tbl_id;
    }

    @FXML
    private ImageView find_img;

    @FXML
    private ImageView ban10_img;

    @FXML
    private ImageView ban11_img;

    @FXML
    private ImageView ban12_img;

    @FXML
    private ImageView ban1_img;

    @FXML
    private ImageView ban2_img;

    @FXML
    private ImageView ban3_img;

    @FXML
    private ImageView ban4_img;

    @FXML
    private ImageView ban5_img;

    @FXML
    private ImageView ban6_img;

    @FXML
    private ImageView ban7_img;

    @FXML
    private ImageView ban8_img;

    @FXML
    private ImageView ban9_img;

    @FXML
    private ComboBox<String> box_nhommon;
    ObservableList<String> list =nv_db_cnt.plList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        box_nhommon.setItems(list);
        show_menu();

        Main m = new Main();
        try {
            m.sc("tt-nv.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        content.getChildren().removeAll();
        try {
            content.getChildren().setAll(m.sc("tt-nv.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @FXML
    private Label test;
    @FXML
    void boxChange(ActionEvent event) {
        tbl_menu.getItems().clear();
        tbl_menu.setItems(nv_db_cnt.phanloai(box_nhommon.getValue()));
        ma_mon_col.setCellValueFactory(new PropertyValueFactory<>("ma_mon"));
        ten_mon_col.setCellValueFactory(new PropertyValueFactory<>("ten_mon"));
        ma_loai_col.setCellValueFactory(new PropertyValueFactory<>("ma_loai"));
        don_gia_col.setCellValueFactory(new PropertyValueFactory<>("price"));
        dv_col.setCellValueFactory(new PropertyValueFactory<>("dv"));

    }


    @FXML
    private TableColumn<?, ?> don_gia_col;

    @FXML
    private TableColumn<?, ?> dv_col;

    @FXML
    private TableColumn<?, ?> ma_loai_col;

    @FXML
    private TableColumn<?, ?> ma_mon_col;

    @FXML
    private Tab menu_btn;

    @FXML
    private Button nv_infor_btn;

    @FXML
    private AnchorPane nv_man;

    @FXML
    private Button order_add_btn;


    @FXML
    private TableColumn<?, ?> order_name;

    @FXML
    private Button order_noti_btn;

    @FXML
    private Button order_pay_btn;

    @FXML
    private TableColumn<?, ?> order_price;

    @FXML
    private TableColumn<?, ?> order_sl;

    @FXML
    private Label order_sum;

    @FXML
    private TableView<ban> order_table;

    @FXML
    private TableColumn<?, ?> price;

    @FXML
    private Button ql_ban_btn;

    @FXML
    private Button ql_menu_btn;

    @FXML
    private Button ql_nv_btn;

    @FXML
    private AnchorPane quan_ly;

    @FXML
    private Tab quan_ly_btn;

    @FXML
    private Tab table_btn;

    @FXML
    private TableView<menu> tbl_menu;

    @FXML
    private TableColumn<?, ?> ten_mon_col;

    @FXML
    private TextField tim_mon_fidle;

    @FXML
    void add(ActionEvent event) {

    }

    @FXML
    private StackPane content;

    @FXML
    void add_click(MouseEvent event) throws IOException {
        //sendData
        Node node = (Node) event.getSource();
        Main m = new Main();
        m.switchSC("order-view.fxml",node,tbl_id);
    }

    @FXML
    void b10_click(MouseEvent event) {
        tbl_id="b10";
        check_ban(tbl_id);
        order_sum.setText(Integer.toString(check_sum(tbl_id)));
    }

    @FXML
    void b11_click(MouseEvent event) {
        tbl_id="b11";
        check_ban(tbl_id);
        order_sum.setText(Integer.toString(check_sum(tbl_id)));
    }

    @FXML
    void b12_click(MouseEvent event) {
        tbl_id="b12";
        check_ban(tbl_id);
        order_sum.setText(Integer.toString(check_sum(tbl_id)));
    }

    @FXML
    void b1_click(MouseEvent event) {
        tbl_id="b1";
        check_ban(tbl_id);
        order_sum.setText(Integer.toString(check_sum(tbl_id)));
    }

    @FXML
    void b2_click(MouseEvent event) {
        tbl_id="b2";
        check_ban(tbl_id);
        order_sum.setText(Integer.toString(check_sum(tbl_id)));
    }

    @FXML
    void b3_click(MouseEvent event) {
        tbl_id="b3";
        check_ban(tbl_id);
        order_sum.setText(Integer.toString(check_sum(tbl_id)));
    }

    @FXML
    void b4_click(MouseEvent event) {
        tbl_id="b4";
        check_ban(tbl_id);
        order_sum.setText(Integer.toString(check_sum(tbl_id)));
    }

    @FXML
    void b5_click(MouseEvent event) {
        tbl_id="b5";
        check_ban(tbl_id);
        order_sum.setText(Integer.toString(check_sum(tbl_id)));
    }

    @FXML
    void b6_click(MouseEvent event) {
        tbl_id="b6";
        check_ban(tbl_id);
        order_sum.setText(Integer.toString(check_sum(tbl_id)));
    }

    @FXML
    void b7_click(MouseEvent event) {
        tbl_id="b7";
        check_ban(tbl_id);
        order_sum.setText(Integer.toString(check_sum(tbl_id)));
    }

    @FXML
    void b8_click(MouseEvent event) {
        tbl_id="b8";
        check_ban(tbl_id);
        order_sum.setText(Integer.toString(check_sum(tbl_id)));
    }

    @FXML
    void b9_click(MouseEvent event) {
        tbl_id="b9";
        check_ban(tbl_id);
        order_sum.setText(Integer.toString(check_sum(tbl_id)));
    }

    @FXML
    void bao_bep(ActionEvent event) {
        // SENT NOTI
    }

    @FXML
    void cancel_click(MouseEvent event) {

    }


    @FXML
    void noti_click(MouseEvent event) {

    }

    @FXML
    void nv_infor_click(MouseEvent event) throws IOException {

        Main m = new Main();
        m.sc("tt-nv.fxml");
        content.getChildren().removeAll();
        content.getChildren().setAll(m.sc("tt-nv.fxml"));
    }

    @FXML
    void order_cancel(ActionEvent event) {

    }

    @FXML
    void order_pay(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cofirmation");
        alert.setHeaderText("Thanh toan thanh cong");
        alert.show();
    }

    @FXML
    void pay_click(MouseEvent event) {

    }


    @FXML
    void ql_ban_click(MouseEvent event) throws IOException {
        Main m = new Main();
        m.sc("ql-ban.fxml");
        content.getChildren().removeAll();
        content.getChildren().setAll(m.sc("ql-ban.fxml"));
    }


    @FXML
    void ql_menu_click(MouseEvent event) throws IOException {
        Main m = new Main();
        m.sc("ql-menu.fxml");
        content.getChildren().removeAll();
        content.getChildren().setAll(m.sc("ql-menu.fxml"));
    }



    @FXML
    void ql_nv_click(MouseEvent event) throws IOException {
        Main m = new Main();
        m.sc("ql-nv.fxml");
        content.getChildren().removeAll();
        content.getChildren().setAll(m.sc("ql-nv.fxml"));
    }

    @FXML
    void find_mon(MouseEvent event) {
        tbl_menu.setItems(nv_db_cnt.find_mon(tim_mon_fidle.getText()));
        ma_mon_col.setCellValueFactory(new PropertyValueFactory<>("ma_mon"));
        ten_mon_col.setCellValueFactory(new PropertyValueFactory<>("ten_mon"));
        ma_loai_col.setCellValueFactory(new PropertyValueFactory<>("ma_loai"));
        don_gia_col.setCellValueFactory(new PropertyValueFactory<>("price"));
        dv_col.setCellValueFactory(new PropertyValueFactory<>("dv"));
    }

    private void show_menu() {
        tbl_menu.setItems(nv_db_cnt.menuInf());
        ma_mon_col.setCellValueFactory(new PropertyValueFactory<>("ma_mon"));
        ten_mon_col.setCellValueFactory(new PropertyValueFactory<>("ten_mon"));
        ma_loai_col.setCellValueFactory(new PropertyValueFactory<>("ma_loai"));
        don_gia_col.setCellValueFactory(new PropertyValueFactory<>("price"));
        dv_col.setCellValueFactory(new PropertyValueFactory<>("dv"));
    }

    private void check_ban(String ma_ban){
        order_table.setItems(nv_db_cnt.check_ban(ma_ban));
        order_name.setCellValueFactory(new PropertyValueFactory<>("ten_mon"));
        order_sl.setCellValueFactory(new PropertyValueFactory<>("amount"));
        order_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        price.setCellValueFactory(new PropertyValueFactory<>("pay"));
    }

    private int check_sum(String ma_ban){
        int sum = nv_db_cnt.order_sum(ma_ban);
        return sum;
    }

}
