package model;


import javafx.beans.property.IntegerProperty;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Model {
  private String host = "localhost";
  private String db   = "db1";
  private String tb   = "tb3";
  private String port = "3306";
  private String user = "vagrant";
  private String pass = "vagrant";
  private String columns = "name";
  private Map<String,String> map;
  private ArrayList<Map<String, String>> list;

  public boolean dbRegest(String str){
    boolean bo = true;
    try{
      Class.forName("org.mariadb.jdbc.Driver");
    }catch (ClassNotFoundException e){
      e.printStackTrace();
    }
    Connection con = null;
    try{
      con = DriverManager.getConnection("jdbc:mariadb://"+host+":"+port+"/"+db,user,pass);
      PreparedStatement ps = con.prepareStatement(
          "insert into "+tb+"("+columns+") values(?)"
      );
      ps.setString(1,str);
      ps.execute();
      ps.close();
    }catch (SQLException e){
      e.printStackTrace();
      bo = false;
    }finally {
      try {
        if (con != null) {
          con.close();
        }
      } catch (SQLException e) {
        e.printStackTrace();
        bo = false;
      }
    }
    return bo;
  }

  public ArrayList<Map<String,String>> dbSearch(String str){
    try{
      Class.forName("org.mariadb.jdbc.Driver");
    }catch (ClassNotFoundException e){
      e.printStackTrace();
    }

    Connection con = null;

    try{
      con = DriverManager.getConnection("jdbc:mariadb://"+host+":"+port+"/"+db,user,pass);
      PreparedStatement ps = con.prepareStatement(
          "select * from tb3 where name = ?"
      );
      ps.setString(1, str);
      // 収納用配列
      ResultSet i = ps.executeQuery();
      this.map = new HashMap<>();
      this.list = new ArrayList<>();

      while (i.next()){
        this.map.clear();
        this.map.put("id",String.valueOf(i.getString("id")));
        this.map.put("name",i.getString("name"));
        System.out.println(this.map.get("id"));
        this.list.add(map);
      }
    }catch (SQLException e){}

    //System.out.println(this.list.get(0));
    //System.out.println(this.list.get(1));
    //System.out.println(this.list.get(2));

    return this.list;
  }
}
