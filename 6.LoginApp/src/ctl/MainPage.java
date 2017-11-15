package ctl;

import app.MainApp;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.viewRecord;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainPage implements Initializable {
    /**
   * instance(シングルトン)
   */
  private static  MainPage instance;
  /**
   * scene(シングルトン)
   */
  private static Scene SCENE;

  @FXML
  private TextField serchTex;
  @FXML
  private TextField addTex;
  @FXML
  private TextField nameTex;
  @FXML
  private TableView<viewRecord> addlessVierw;
  @FXML
  private TableColumn<viewRecord,String> nameColumn;
  @FXML
  private TableColumn<viewRecord,String> mallColumn;

  private ObservableList<viewRecord> data;
//  private ObservableList<viewRecord> data = FXCollections.observableArrayList(
//          new viewRecord("intithoge1","hogehoe1"),
//          new viewRecord("inithoge2","hogehoe2")
//  );

  static {
    FXMLLoader fxmlLoader = new FXMLLoader(ClassLoader.getSystemResource("veiw/MainV.fxml"));
    try{
      fxmlLoader.load();
    }catch (IOException e){
      e.printStackTrace();
    }
    Parent parent = fxmlLoader.getRoot();
    Scene s = new Scene(parent);
    SCENE = s;
    instance =fxmlLoader.getController();
  }

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    this.data = FXCollections.observableArrayList(
          new viewRecord("intithoge1","hogehoe1"),
          new viewRecord("inithoge2","hogehoe2")
    );
    addlessVierw.setItems(data);
    nameColumn.setCellValueFactory(new PropertyValueFactory<viewRecord,String>("MAILADDRESS"));
    mallColumn.setCellValueFactory(new PropertyValueFactory<viewRecord,String>("NAME"));
    addlessVierw.getSelectionModel().selectedItemProperty().addListener((observable,oldVal,newVal )->{
      // ぽるぽが発生したら落とす
      if(newVal == null){ return; }
        this.addTex.setText(newVal.getMAILADDRESS());
        this.nameTex.setText(newVal.getNAME());
    });
  }

  /**
   * シングルトンインスタンスを返す
   */
  public static MainPage getInstance(){
    return instance;
  }

  /**
   * 表示する
   */
  public void show(){
    MainApp.presentStage.setScene(SCENE);
  }

  @FXML
  public void onSerch(){
    this.addTex.clear();
    this.nameTex.clear();
    data.clear();

    this.addlessVierw.getItems().add(new viewRecord("hoge1","foo1"));
    this.addlessVierw.getItems().add(new viewRecord("hoge2","foo2"));
    this.addlessVierw.getItems().add(new viewRecord("hoge3","foo3"));
  }
}
