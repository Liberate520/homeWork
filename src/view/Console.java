package view;

import java.time.LocalDate;
import java.util.Scanner;

import model.familyTree.FamilyTree;
import model.human.Gender;
import model.human.Human;
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

  public void setFamilyTree(FamilyTree<Human> tree) {
    presenter.setFamilyTree(tree);
  }

  public void getHumanList() {
    presenter.getHumanList();
  }

  public void addHuman(String name, Gender gender, LocalDate birthDate, long idFather, long idMother) {
    String genderString = gender.toString();
    String birthDateString = birthDate.toString();
    presenter.addHuman(name, genderString, birthDateString, idFather, idMother);
  }

  public void sortByName() {
    presenter.sortByName();
    getHumanList();
  }

  public void sortByBirthDate() {
    presenter.sortByBirthDate();
    getHumanList();
  }
}
