package app;

import ctl.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainApp extends Application {

    // 共有するステージオブジェクト
  public static Stage presentStage;

    @Override
    public void start(Stage stage) throws Exception{
      // 共有オブジェクトに引き渡し
      this.presentStage= stage;

      // アプリのタイトル
      stage.setTitle("メールアドレス管理");

      // 空のsceneを作成
      Scene scene = new Scene(new Pane());
      stage.setScene(scene);

      // 最初のログイン画面教示
      LoginController.getInstance().show();

      // 表示
      stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
