package model;

import javax.annotation.processing.SupportedSourceVersion;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class AllData {
  private String dbPath = "6.LoginApp/db/db.sqlite3";
  private ArrayList<HashMap<String,String>> list;
  private HashMap<String,String> map;

  public AllData(){
    try{
      Class.forName("org.sqlite.JDBC");
    }catch (ClassNotFoundException e){
      e.printStackTrace();
    }
    Connection con = null;
    try {
      con = DriverManager.getConnection("jdbc:sqlite:" + this.dbPath);
      PreparedStatement ps = con.prepareStatement("select * from address_list;");

      ResultSet rs = ps.executeQuery();

      this.list = new ArrayList<>();
      while (rs.next()) {
        this.map = new HashMap<String, String>();
        this.map.put("address", rs.getString("address"));
        this.map.put("name", rs.getString("name"));
        this.list.add(this.map);
      }
      rs.close();
      ps.close();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (con != null) {
        try {
          con.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
    for(int i = 0;i < list.size();i++){
      System.out.println(list.get(i).get("address") + list.get(i).get("name"));
    }
  }

  public ArrayList<HashMap<String, String>> getList() {
    return list;
  }
}