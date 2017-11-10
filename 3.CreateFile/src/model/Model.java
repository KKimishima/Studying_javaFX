package model;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Model {
  public void fileW(File file,String tex){
    try{
      FileWriter fw = new FileWriter(file,true);
      fw.write(tex+"\n");
      fw.flush();
      fw.close();
    }catch (IOException e){
      e.printStackTrace();
    }
  }
  public String fileL(String path){
    StringBuffer stringBuffer = new StringBuffer();
    try{
      FileReader fr = new FileReader(path);
      int i = fr.read();
      while (i != -1){
        char c = (char)i;
        stringBuffer.append(c);
        i = fr.read();
      }
      fr.close();
    }catch (IOException e){
      e.printStackTrace();
    }
    return stringBuffer.toString();
  }
}
