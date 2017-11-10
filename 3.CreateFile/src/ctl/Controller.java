package ctl;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import model.Model;

import java.io.File;

public class Controller{
  Model model = new Model();
  @FXML
  private TextField wirterTex;

  @FXML TextField leadTex;

  // ファイル選択用
  FileChooser fileChooser = new FileChooser();

  @FXML
  public void onWriter() {
    fileChooser.setTitle("ファイルを選択してください");
    File selectedFile =fileChooser.showOpenDialog(null);
    if (selectedFile != null) {
      model.fileW(selectedFile,wirterTex.getText());
    }
    else {
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("確認");
      alert.setHeaderText("確認ダイアログ");
      alert.setContentText("ファイルが選択されていません");
      alert.show();
    }
  }
  @FXML
  public void onLead(){
     fileChooser.setTitle("ファイルを選択してください");
    File selectedFile =fileChooser.showOpenDialog(null);
    if (selectedFile != null) {
      String tex =  model.fileL(selectedFile.getPath());
      leadTex.setText(tex);
    }
    else {
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("確認");
      alert.setHeaderText("確認ダイアログ");
      alert.setContentText("ファイルが選択されていません");
      alert.show();
    }
  }
}

