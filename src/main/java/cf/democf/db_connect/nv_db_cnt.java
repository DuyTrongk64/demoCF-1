package cf.democf.db_connect;

import cf.democf.model.*;

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

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class nv_db_cnt {
    //ds nv
    public static ObservableList<nhan_vien> findAll() {
        ObservableList<nhan_vien> nhan_vienList = FXCollections.observableArrayList();
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
                nhan_vienList.add( new nhan_vien(resultset.getString("nv_id"),
                        resultset.getString("nv_name"),resultset.getString("cccd"),resultset.getInt("age"),
                        resultset.getBoolean("gender"),resultset.getString("phone_num"),
                        resultset.getString("mail"),resultset.getString("address"),resultset.getString("user_name"),
                        resultset.getString("pass_word")
                ));

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

    //them nv
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

    // chinh sua thong tin
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

    //xoa nv
    public static void delete(String input) {
        String url = "jdbc:postgresql://localhost:5432/demoCF";

        String user = "postgres";

        String password = "12345";

        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            String sql = "delete from nhanvien where nv_id=?";
            statement = conn.prepareCall(sql);
            statement.setString(1, "%"+input+"%");
            statement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(nv_db_cnt.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // tim nv
    public static ObservableList<nhan_vien> find_nv(String input) {
        ObservableList<nhan_vien> nhan_vienList = FXCollections.observableArrayList();

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

    // ds phan loai
    public static ObservableList<String> plList(){
        ObservableList<String> pl =FXCollections.observableArrayList();
        String url = "jdbc:postgresql://localhost:5432/demoCF";

        String user = "postgres";

        String password = "12345";
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            pl.clear();
            conn = DriverManager.getConnection(url, user, password);
            String sql = "select ten_loai from phanloai";
            statement = conn.prepareCall(sql);
            ResultSet resultset = statement.executeQuery();
            while (resultset.next()) {
                pl.add(new String( resultset.getString("ten_loai"))) ;

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
        return pl;
    }

    //find by phan loai
    public static ObservableList<menu> phanloai(String ten_loai){
        ObservableList<menu> pl =FXCollections.observableArrayList();
        String url = "jdbc:postgresql://localhost:5432/demoCF";

        String user = "postgres";

        String password = "12345";
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            pl.clear();
            conn = DriverManager.getConnection(url, user, password);
            String sql = "select * from find_by_tl('" + ten_loai + "')";
            statement = conn.prepareCall(sql);
            ResultSet resultset = statement.executeQuery();
            while (resultset.next()) {
                pl.add(new menu( resultset.getString("ma_mon"),resultset.getString("ten_mon"),
                        resultset.getString("ma_loai"),resultset.getInt("price"),
                        resultset.getString("dv")
                )) ;

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
        return pl;
    }
    //check hoa don hien tai cua ban'
     public static ObservableList<ban> check_ban(String ma_ban){
         ObservableList<ban>  banList = FXCollections.observableArrayList();

         String url = "jdbc:postgresql://localhost:5432/demoCF";

         String user = "postgres";

         String password = "12345";
         Connection conn = null;
         PreparedStatement statement = null;

         try {
             banList.clear();
             conn = DriverManager.getConnection(url, user, password);
             String sql = "select * from tables_inf('" + ma_ban + "')";
             statement = conn.prepareCall(sql);
             //statement.setString(1, "%"+ma_ban+"%");
             ResultSet resultset = statement.executeQuery();
             while (resultset.next()) {
                 banList.add(new ban( resultset.getString("ten_mon"),resultset.getInt("amount")
                         ,resultset.getInt("price"),resultset.getInt("pay")
                 )) ;

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

         return banList;
     }

     // find mon
     public static ObservableList<menu> find_mon(String ten_mon){
         ObservableList<menu>  menuList = FXCollections.observableArrayList();

         String url = "jdbc:postgresql://localhost:5432/demoCF";

         String user = "postgres";

         String password = "12345";
         Connection conn = null;
         PreparedStatement statement = null;

         try {
             menuList.clear();
             conn = DriverManager.getConnection(url, user, password);
             String sql = "select ten_mon,price,dv from menu where ten_mon like '%" + ten_mon + "%'" ;
             statement = conn.prepareCall(sql);
             //statement.setString(1, "%"+ma_ban+"%");
             ResultSet resultset = statement.executeQuery();
             while (resultset.next()) {
                 menuList.add(new menu( resultset.getString("ten_mon")
                         ,resultset.getInt("price"),resultset.getString("dv"))
                 ) ;

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

         return menuList;
     }

     // them mon order
    public static void addOrder(String receipt_id,String ma_mon, int amount){
        String url = "jdbc:postgresql://localhost:5432/demoCF";

        String user = "postgres";

        String password = "12345";
        Connection conn = null;
        PreparedStatement statement = null;

        try {

            conn = DriverManager.getConnection(url, user, password);
            String sql = "insert into receipt_infor(receipt_id, ma_mon, amount) values (?,?,?)";
            statement = conn.prepareCall(sql);
            statement.setString(1,receipt_id);
            statement.setString(2,ma_mon);
            statement.setInt(3,amount);
            ResultSet resultset = statement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(nv_db_cnt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //trich ma hoa don
    public static String mhd(String tbl_id){
        String mhd = "1";
        String url = "jdbc:postgresql://localhost:5432/demoCF";

        String user = "postgres";

        String password = "12345";
        Connection conn = null;
        PreparedStatement statement = null;

        try {

            conn = DriverManager.getConnection(url, user, password);
            String sql = "select receipt_id from recieipt where tbl_id = ? and trang_thai=true";
            statement = conn.prepareCall(sql);
            statement.setString(1, "%"+tbl_id+"%");
            ResultSet resultset = statement.executeQuery();
            while (resultset.next()) {
                mhd=resultset.getString("receipt_id") ;
            }
        } catch (SQLException ex) {
            Logger.getLogger(nv_db_cnt.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mhd;
    }
     // tong tien trong hoa don
    public static int order_sum(String ma_ban){

        int sum=0;
        String url = "jdbc:postgresql://localhost:5432/demoCF";

        String user = "postgres";

        String password = "12345";
        Connection conn = null;
        PreparedStatement statement = null;

        try {

            conn = DriverManager.getConnection(url, user, password);
            String sql = "select sum from receipt where tbl_id like ?";
            statement = conn.prepareCall(sql);
            statement.setString(1,ma_ban);
            ResultSet resultset = statement.executeQuery();
            while (resultset.next()) {
                sum=resultset.getInt("sum") ;
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
        return sum;
    }
     // lay ds menu
     public static ObservableList<menu> menuInf(){
         ObservableList<menu>  menuList = FXCollections.observableArrayList();
         String url = "jdbc:postgresql://localhost:5432/demoCF";

         String user = "postgres";

         String password = "12345";
         Connection conn = null;
         PreparedStatement statement = null;

         try {
             menuList.clear();
             conn = DriverManager.getConnection(url, user, password);
             String sql = "select * from menu";
             statement = conn.prepareCall(sql);
             ResultSet resultset = statement.executeQuery();
             while (resultset.next()) {
                 menuList.add(new menu( resultset.getString("ma_mon"),resultset.getString("ten_mon"),
                         resultset.getString("ma_loai"),resultset.getInt("price"),
                         resultset.getString("dv")
                 )) ;

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
        return menuList;
     }

    public static ObservableList<tables> tablesList(){
        ObservableList<tables>  tablesList = FXCollections.observableArrayList();
        String url = "jdbc:postgresql://localhost:5432/demoCF";

        String user = "postgres";

        String password = "12345";
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            tablesList.clear();
            conn = DriverManager.getConnection(url, user, password);
            String sql = "select * from tables";
            statement = conn.prepareCall(sql);
            ResultSet resultset = statement.executeQuery();
            while (resultset.next()) {
                tablesList.add(new tables( resultset.getString("tbl_id"),resultset.getString("tbl_name"),resultset.getBoolean("status")) );

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
        return tablesList;
    }

    public static ObservableList<tables> findTbl(String input){
        ObservableList<tables>  tablesList = FXCollections.observableArrayList();
        String url = "jdbc:postgresql://localhost:5432/demoCF";

        String user = "postgres";

        String password = "12345";
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            tablesList.clear();
            conn = DriverManager.getConnection(url, user, password);
            String sql = "select * from tables where tbl_id like ? or tbl_name like ? ";
            statement = conn.prepareCall(sql);
            statement.setString(1, "%"+input+"%");
            statement.setString(2, "%"+input+"%");

            ResultSet resultset = statement.executeQuery();
            while (resultset.next()) {
                tablesList.add(new tables( resultset.getString("tbl_id"),resultset.getString("tbl_name"),resultset.getBoolean("status")) );

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
        return tablesList;
    }

    // insert menu
    public static void insertMenu(menu m) {

        String url = "jdbc:postgresql://localhost:5432/demoCF";

        String user = "postgres";

        String password = "12345";

        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            String sql = "insert into nhanvien(menu(ma_mon, ten_mon, ma_loai, price, dv) values(?,?,?,?,?)";
            statement = conn.prepareCall(sql);
            statement.setString(1, m.getMa_mon());
            statement.setString(2, m.getTen_mon());
            statement.setString(3, m.getMa_loai());
            statement.setInt(4, m.getPrice());
            statement.setString(5, m.getDv());
            ;

            statement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(nv_db_cnt.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
