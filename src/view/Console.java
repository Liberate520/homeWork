package view;

import java.util.Scanner;

import presenter.Presenter;

public class Console implements View {
  private Presenter presenter;
  private boolean work;
  private Scanner scanner;
  private Menu menu;

  public Console() {
    presenter = new Presenter(this);
    scanner = new Scanner(System.in);
    menu = new Menu(this);
    work = true;
  }

  @Override
  public void start() {
    while (work) {
      System.out.println(menu.print());
      String choice = scanner.nextLine();
      menu.execute(choice);
    }
  }

  @Override
  public void print(String text) {
    System.out.println(text);
  }

  public void getHumanList() {
    String humanList = presenter.getHumanList();
    print(humanList);
  }
}
