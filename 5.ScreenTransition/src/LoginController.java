import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

import java.io.IOException;

public class LoginController {
  /**
   * instance(singleton)
   */
  private static final LoginController instance;
  /**
   * Scene(singleton)
   */
  private static final Scene SCENE;
  static {
    FXMLLoader fxmlLoader = new FXMLLoader(ClassLoader.getSystemResource("login.fxml"));
    try {
      fxmlLoader.load();
    } catch (IOException e) {
      // loggerを使って何かしら出すほうがいいですね。手抜きですみません
      e.printStackTrace();
    }
    Parent parent = fxmlLoader.getRoot();
    Scene s = new Scene(parent);
    //s.setFill(Color.TRANSPARENT);
    SCENE = s;
    instance = fxmlLoader.getController();
  }

  /**
   * singletonのインスタンスを返す
   * @return instance
   */
  public static LoginController getInstance() {
    return instance;
  }

  /**
   * 表示する
   */
  public void show() {
    SampleMain.presentStage.setScene(SCENE);
  }

  @FXML
  public void onClick() {
    // クリック時の処理とか色々して~~~次のページ表示
    FirstContent.getInstance().show();
  }
}