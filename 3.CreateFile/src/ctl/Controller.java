package ctl;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;

public class Controller{
  @FXML
  private Button button;
  @FXML
  private TextField ab;

  FileChooser fileChooser = new FileChooser();
  @FXML
  public void onButton() {
    fileChooser.setTitle("ファイルを選択してください");
    File selectedFile =fileChooser.showOpenDialog(null);
    if (selectedFile != null) {
      ab.setText("成功"+":"+selectedFile.getName());
    }
    else {
      ab.setText("失敗");
    }
  }
}

