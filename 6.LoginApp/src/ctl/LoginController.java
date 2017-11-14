package ctl;

import app.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.LoginM;

import java.io.IOException;

public class LoginController {
  /**
   * instance(シングルトン)
   */
  private static  LoginController instance;
  /**
   * scene(シングルトン)
   */
  private static  Scene SCENE;

//  private static LoginController loginC = new LoginController();
  LoginM lo = new LoginM();

  @FXML
  private TextField user_idTex;
  @FXML
  private PasswordField user_passTex;
  @FXML
  private Label logMesse;

  static {
    FXMLLoader fxmlLoader = new FXMLLoader(ClassLoader.getSystemResource("veiw/loginVe.fxml"));
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

  /**
   * シングルトンインスタンスを返す
   */
  public static LoginController getInstance(){
    return instance;
  }

  /**
   * 表示する
   */
  public void show(){
    MainApp.presentStage.setScene(SCENE);
  }
  @FXML
  public void onLogin(){
    // sqlユーザ名確認
    boolean bo = this.lo.sqlEx(this.user_idTex.getText(),this.user_passTex.getText());
    if(bo){
      MainPage.getInstance().show();
    }else{
      logMesse.setText("ログイン失敗");
    }
  }

}
