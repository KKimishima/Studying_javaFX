package ctl;

import app.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.io.IOException;

public class MainPage {
    /**
   * instance(シングルトン)
   */
  private static  MainPage instance;
  /**
   * scene(シングルトン)
   */
  private static Scene SCENE;

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

  //public void Initializable(){
  //}

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

}
