package app;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class app extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    try {
      // viewの読み込み
      Parent root = FXMLLoader.load(getClass().getResource("view.fxml"));
      // タイトルの設定
      primaryStage.setTitle("ランダム生成");
      // シーンの作製と設定
      Scene scene = new Scene(root);

      primaryStage.setScene(scene);
      primaryStage.show();

    }catch (IOException e){
      e.printStackTrace();
    }
  }
}
