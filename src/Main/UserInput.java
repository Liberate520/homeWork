package src.Main;

import java.util.Scanner;

public class UserInput {
  private Scanner input = new Scanner(System.in);

  public int getInt() {
    return input.nextInt();
  }

  public String getString() {
    return input.next();
  }

  public void closeInput() {
    input.close();
  }
}
