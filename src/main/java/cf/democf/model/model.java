package cf.democf.model;

import cf.democf.Main;
import cf.democf.db_connect.nv_db_cnt;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class model {
    List<nhan_vien> nhan_vienList = nv_db_cnt.findAll();
    DefaultTableModel tblModel;

    public void showds_nv() {
        List<nhan_vien> nhan_vienList = nv_db_cnt.findAll();
        tblModel.setRowCount(0);
        nhan_vienList.forEach(nhan_vien -> {
            tblModel.addRow(new Object[]{ nhan_vien.getNv_id(),nhan_vien.getNv_name(),
                    nhan_vien.getCccd(), nhan_vien.getAge(),nhan_vien.isGender(),nhan_vien.getPhone_num(),
                    nhan_vien.getMail(),nhan_vien.getAddress(),nhan_vien.getUser_name(),nhan_vien.getPass_word()});
        });
    }


    public void checkLogin(String user, String pass) throws IOException {
        Main m = new Main();
        boolean chk=nv_db_cnt.findUser(user,pass);
        if(chk) m.switchScene("nv-main-view.fxml");
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Cofirmation");
            alert.setHeaderText("Dang nhap that bai");
            alert.show();
        }
    }
}
