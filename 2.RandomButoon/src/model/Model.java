package model;

import java.util.Random;

public class Model {

  public String setRand(int rand) {
    Random sw = new Random();
    Random num = new Random();
    StringBuffer stringBuffer = new StringBuffer();
    for (int i = 0; i < rand; i++) {
      switch (sw.nextInt(3)) {
        case 0:
          stringBuffer.append(String.valueOf(num.nextInt(10)));
          break;
        case 1:
          stringBuffer.append((char) (num.nextInt(26) + 65));
          break;
        case 2:
          stringBuffer.append((char) (num.nextInt(26) + 97));
          break;
      }
    }
    return stringBuffer.toString();
  }
}
