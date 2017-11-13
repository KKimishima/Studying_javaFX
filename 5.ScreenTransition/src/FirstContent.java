import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class FirstContent {
  /**
   * instance(singleton)
   */
  private static final FirstContent instance;
  /**
   * Scene(singleton)
   */
  private static final Scene SCENE;
  static {
    FXMLLoader fxmlLoader = new FXMLLoader(ClassLoader.getSystemResource("fa.fxml"));
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
  public static FirstContent getInstance() {
    return instance;
  }

  /**
   * 表示する
   */
  public void show() {
    SampleMain.presentStage.setScene(SCENE);
  }
}
