package model;

import java.sql.*;

public class LoginM {
  private String dbPath  = "6.LoginApp/db/db.sqlite3";
  //private Connection con = null;
  //private Statement st   = null;

  public LoginM() {
    // ドライバ読み込み
    try {
      Class.forName("org.sqlite.JDBC");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
  public boolean sqlEx(String user_id,String user_pass){
    boolean boo = false;

    // コネクション確立
    Connection con = null;
    try {
      con = DriverManager.getConnection("jdbc:sqlite:"+ this.dbPath);
      // sql処理
      PreparedStatement ps = con.prepareStatement(
          "select * from login where user_id = ? and  user_pass = ?;"
      );
      ps.setString(1,user_id);
      ps.setString(2,user_pass);

      ResultSet rs = ps.executeQuery();
      if(rs.next()){
        boo = true;
      }
    }catch (SQLException e){
      e.printStackTrace();
    }finally {
      if(con != null) {
        try {
          con.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
    return boo;
  }
}
