package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class viewRecord {
  private String name;
  private String mailAddress;

  public viewRecord(String name,String mailAddress){
    this.name = name;
    this.mailAddress = mailAddress;
  }

  public void setNAME(String name) {
    this.name = name;
  }

  public void setMAILADDRESS(String mailAddress) {
    this.mailAddress = mailAddress;
  }

  public String getMAILADDRESS() {
    return mailAddress;
  }
  public String getNAME() {
    return name;
  }
}
