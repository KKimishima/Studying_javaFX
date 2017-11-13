import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SampleMain extends Application {

  // 他のControllerから取得するためのStage(できれば別クラスを用意する)
  public static Stage presentStage;

  public static void main(String[] args){
    Application.launch(args);
  }

  @Override
  public void start(Stage stage) throws Exception {
    presentStage = stage;

    // タイトル
    stage.setTitle("Sample");

    // sceneの作成(nullですので中身ないです)
    Scene scene = new Scene(new Pane());
    stage.setScene(scene);

    // 最初の画面
    LoginController.getInstance().show();

    // 表示
    stage.show();
  }

}