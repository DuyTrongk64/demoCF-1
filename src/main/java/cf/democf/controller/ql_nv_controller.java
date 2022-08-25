package cf.democf.controller;

import cf.democf.Main;
import cf.democf.db_connect.nv_db_cnt;
import cf.democf.model.nhan_vien;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ql_nv_controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        shownv();
    }

    @FXML
    private Button add;

    @FXML
    private TableColumn<?, ?> adr;

    @FXML
    private TableColumn<?, ?> age;

    @FXML
    private TableColumn<?, ?> cccd;

    @FXML
    private TextField field;

    @FXML
    private ImageView find;

    @FXML
    private TableColumn<?, ?> gt;

    @FXML
    private TableColumn<?, ?> id;

    @FXML
    private TableColumn<?, ?> mail;

    @FXML
    private TableColumn<?, ?> name;

    @FXML
    private TableView<nhan_vien> nv_table;

    @FXML
    private TableColumn<?, ?> pass;

    @FXML
    private TableColumn<?, ?> pq;

    @FXML
    private TableColumn<?, ?> sdt;

    @FXML
    private Button sua;

    @FXML
    private TableColumn<?, ?> usn;

    @FXML
    private Button xoa;

    @FXML
    void add(MouseEvent event) throws IOException {
        Main m = new Main();
        m.switchScene("add-nv.fxml");
    }

    @FXML
    void find(MouseEvent event) {
        nv_table.getItems().removeAll();
        nv_table.setItems(nv_db_cnt.find_nv(field.getText()));
        id.setCellValueFactory(new PropertyValueFactory<>("nv_id"));
        name.setCellValueFactory(new PropertyValueFactory<>("nv_name"));
        cccd.setCellValueFactory(new PropertyValueFactory<>("cccd"));
        age.setCellValueFactory(new PropertyValueFactory<>("age"));
        gt.setCellValueFactory(new PropertyValueFactory<>("gender"));
        sdt.setCellValueFactory(new PropertyValueFactory<>("phone_num"));
        mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
        adr.setCellValueFactory(new PropertyValueFactory<>("address"));
        usn.setCellValueFactory(new PropertyValueFactory<>("user_name"));
        pass.setCellValueFactory(new PropertyValueFactory<>("pass_word"));
        pq.setCellValueFactory(new PropertyValueFactory<>("phan_quyen"));
    }

    @FXML
    void sua(MouseEvent event) throws IOException {
        nhan_vien selected =nv_table.getSelectionModel().getSelectedItem();
        Node node = (Node) event.getSource();
        Main m = new Main();
        m.switchSV("sua-nv.fxml",node,selected);
    }


    @FXML
    void xoa(MouseEvent event) {
        nhan_vien selected =nv_table.getSelectionModel().getSelectedItem();
        nv_db_cnt.delete(selected.getNv_id());
        System.out.println(selected.getNv_id());
        shownv();
    }

    private void shownv(){
        nv_table.getItems().removeAll();
        nv_table.setItems(nv_db_cnt.findAll());
        id.setCellValueFactory(new PropertyValueFactory<>("nv_id"));
        name.setCellValueFactory(new PropertyValueFactory<>("nv_name"));
        cccd.setCellValueFactory(new PropertyValueFactory<>("cccd"));
        age.setCellValueFactory(new PropertyValueFactory<>("age"));
        gt.setCellValueFactory(new PropertyValueFactory<>("gender"));
        sdt.setCellValueFactory(new PropertyValueFactory<>("phone_num"));
        mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
        adr.setCellValueFactory(new PropertyValueFactory<>("address"));
        usn.setCellValueFactory(new PropertyValueFactory<>("user_name"));
        pass.setCellValueFactory(new PropertyValueFactory<>("pass_word"));
        pq.setCellValueFactory(new PropertyValueFactory<>("phan_quyen"));
    }
}
