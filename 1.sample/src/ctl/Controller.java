package ctl;

import Model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
  Model model = new Model();
  @FXML
  private Button button;
  @FXML
  private TextField textF;

  @FXML
  public void onButton(){
    String str = model.setviewStr();
    this.textF.setText(str);
  }
}
