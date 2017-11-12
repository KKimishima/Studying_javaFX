package ctl;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Data;
import model.Model;

import java.util.ArrayList;
import java.util.Map;

public class Controller {
  Model model = new Model();
  private ArrayList<Map<String, String>> list;

  @FXML
  private TextField regeTex;
  @FXML
  private TextField searchTex;
  @FXML
  private TableView<Data> table;
  @FXML
  private TableColumn<Data,String> idCol;
  @FXML
  private TableColumn<Data,String> nameCol;

  @FXML
  public void onRege(){
    if(regeTex.getText().isEmpty()){
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setContentText("文字を入力してください");
      alert.show();
      return;
    }
    if(model.dbRegest(regeTex.getText())){
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setContentText("登録成功");
      alert.show();
    }else{
      Alert alert= new Alert(Alert.AlertType.ERROR);
      alert.setContentText("登録失敗");
      alert.show();
    }
  }
  @FXML
  public void onSearch(){
    // 結果の取得
    this.list = model.dbSearch(searchTex.getText());
    // 表の中の初期化
    table.getItems().clear();
    // 登録用クラスを登録
    idCol.setCellValueFactory(new PropertyValueFactory<Data,String>("Id"));
    nameCol.setCellValueFactory(new PropertyValueFactory<Data,String>("Name"));
    // テーブルビューに使い
    ObservableList<Data> list = table.getItems();
    for (int i =0;i < this.list.size();i++){
      list.add(new Data(this.list.get(i).get("id"),this.list.get(i).get("name")));
    }
  }
}
