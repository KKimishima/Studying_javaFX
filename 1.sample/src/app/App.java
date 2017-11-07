package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class App extends Application{
  @Override
  public void start(Stage primaryStage) {
    try{
      // viewの読み込み
      Parent root = FXMLLoader.load(getClass().getResource("view.fxml"));

      // メインウィンドウの設定
      primaryStage.setTitle("サンプルjavaFX");
      //primaryStage.setWidth(400);
      //primaryStage.setHeight(300);

      // 表示にviewに引き渡し
      Scene scene = new Scene(root);
      // ウィンドウ情報
      primaryStage.setScene(scene);
      // 表示
      primaryStage.show();
    }catch (IOException e){
      e.printStackTrace();
    }
  }
  public static void main(String[] args) {
    launch(args);
  }
}
