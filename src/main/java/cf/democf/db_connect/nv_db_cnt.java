package cf.democf.db_connect;

import cf.democf.model.nhan_vien;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;

public class nv_db_cnt {
    public static List<nhan_vien> findAll() {
        List<nhan_vien> nhan_vienList = new ArrayList<>();
        String url = "jdbc:postgresql://localhost:5432/demoCF";

        String user = "postgres";

        String password = "12345";
        Connection conn = null;
        Statement statement = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            String sql = "select * from nhanvien";
            statement = conn.createStatement();
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                nhan_vien nhan_vien = new nhan_vien(resultset.getString("nv_id"),
                        resultset.getString("nv_name"),resultset.getString("cccd"),resultset.getInt("age"),
                        resultset.getBoolean("gender"),resultset.getString("phone_num"),
                        resultset.getString("mail"),resultset.getString("address"),resultset.getString("user_name"),
                        resultset.getString("pass_word")
                );
                nhan_vienList.add(nhan_vien);
            }
        } catch (SQLException ex) {
            Logger.getLogger(nv_db_cnt.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(nv_db_cnt.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(nv_db_cnt.class.getName()).log(Level.SEVERE, null, ex);

                    }

                }
            }
        }

        return nhan_vienList;

    }

    public static void insert(nhan_vien nhan_vien) {

        String url = "jdbc:postgresql://localhost:5432/demoCF";

        String user = "postgres";

        String password = "12345";

        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            String sql = "insert into nhanvien(nv_id,nv_name,cccd,age,gender,phone_num,mail,address,user_name,pass_word,phan_quyen) values(?,?,?,?,?,?,?,?,?,?,?)";
            statement = conn.prepareCall(sql);
            statement.setString(1, nhan_vien.getNv_id());
            statement.setString(2, nhan_vien.getNv_name());
            statement.setString(3, nhan_vien.getCccd());
            statement.setInt(4, nhan_vien.getAge());
            statement.setBoolean(5, nhan_vien.isGender());
            statement.setString(6, nhan_vien.getPhone_num());
            statement.setString(7, nhan_vien.getMail());
            statement.setString(8, nhan_vien.getAddress());
            statement.setString(9, nhan_vien.getUser_name());
            statement.setString(10, nhan_vien.getPass_word());
            statement.setBoolean(11,nhan_vien.isPhan_quyen());

            statement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(nv_db_cnt.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void update(nhan_vien nhan_vien) {

        String url = "jdbc:postgresql://localhost:5432/demoCF";

        String user = "postgres";

        String password = "12345";

        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            String sql = "update nhanvien set nv_id=?,nv_name=?,cccd=?,age=?,gender=?,phone_num=?,mail=?,address=?,user_name=?,pass_word=?,phan_quyen=?";
            statement = conn.prepareCall(sql);
            statement.setString(1, nhan_vien.getNv_id());
            statement.setString(2, nhan_vien.getNv_name());
            statement.setString(3, nhan_vien.getCccd());
            statement.setInt(4, nhan_vien.getAge());
            statement.setBoolean(5, nhan_vien.isGender());
            statement.setString(6, nhan_vien.getPhone_num());
            statement.setString(7, nhan_vien.getMail());
            statement.setString(8, nhan_vien.getAddress());
            statement.setString(9, nhan_vien.getUser_name());
            statement.setString(10, nhan_vien.getPass_word());
            statement.setBoolean(11,nhan_vien.isPhan_quyen());
            statement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(nv_db_cnt.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void delete(String input) {
        String url = "jdbc:postgresql://localhost:5432/demoCF";

        String user = "postgres";

        String password = "12345";

        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            String sql = "delete from nhanvien where id=? or nv_name like ? or cccd like ?";
            statement = conn.prepareCall(sql);
            statement.setString(1, "%"+input+"%");
            statement.setString(2, "%"+input+"%");
            statement.setString(3, "%"+input+"%");
            statement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(nv_db_cnt.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static List<nhan_vien> find(String input) {
        List<nhan_vien> nhan_vienList = new ArrayList<>();

        String url = "jdbc:postgresql://localhost:5432/demoCF";

        String user = "postgres";

        String password = "12345";
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            String sql = "select * from nhanvien where nv_id like ? or nv_name like ? or cccd like ?";
            statement = conn.prepareCall(sql);
            statement.setString(1, "%"+input+"%");
            statement.setString(2, "%"+input+"%");
            statement.setString(3, "%"+input+"%");
            ResultSet resultset = statement.executeQuery();
            while (resultset.next()) {
                nhan_vien nhan_vien = new nhan_vien(resultset.getString("nv_id"),
                        resultset.getString("nv_name"),resultset.getString("cccd"),resultset.getInt("age"),
                        resultset.getBoolean("gender"),resultset.getString("phone_num"),
                        resultset.getString("mail"),resultset.getString("address"),resultset.getString("user_name"),
                        resultset.getString("pass_word")
                );
                nhan_vienList.add(nhan_vien);
            }
        } catch (SQLException ex) {
            Logger.getLogger(nv_db_cnt.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(nv_db_cnt.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(nv_db_cnt.class.getName()).log(Level.SEVERE, null, ex);

                    }

                }
            }
        }
        return nhan_vienList;
    }

    public static boolean findUser(String user_name, String pass) {
        List<nhan_vien> nhan_vienList = new ArrayList<>();
        
        boolean chk = true;
        String pw=null;
        
        String url = "jdbc:postgresql://localhost:5432/demoCF";

        String user = "postgres";

        String password = "12345";
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            String sql = "select pass_word from nhanvien where user_name like ? and pass_word like ?";
            statement = conn.prepareCall(sql);
            statement.setString(1, "%"+user_name+"%");
            statement.setString(2, "%"+pass+"%");
            ResultSet resultset = statement.executeQuery();
            if(resultset.next()){
                 chk=true;
            }
            else chk=false;
        } catch (SQLException ex) {
            Logger.getLogger(nv_db_cnt.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(nv_db_cnt.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(nv_db_cnt.class.getName()).log(Level.SEVERE, null, ex);

                    }

                }
            }
        }
        return chk;
    }
}
