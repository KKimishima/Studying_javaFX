package ctl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import model.Model;


public class Controller {
  Model model = new Model();

  @FXML
  TextField texRand;
  @FXML
  TextField texNum;
  @FXML
  Slider slider;

  public void initialize(){
    this.texNum.setText("4");

  }
  @FXML
  public void onButton(){

    int sliderValue =(int)slider.getValue();
    texRand.setText(model.setRand(sliderValue));

    System.out.println(texRand.getText()+":"+sliderValue);

  }
  @FXML
  public void onSlider(){
    texNum.setText(String.valueOf((int)slider.getValue()));
    System.out.println("スライドイベント");
  }
}
