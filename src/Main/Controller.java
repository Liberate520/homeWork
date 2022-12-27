package src.Main;

import java.util.Map;

import src.FTService;
import src.Entities.FamilyTree;
import src.Entities.Human;
import src.FileProcessing.FileWorker;

public class Controller<T extends Human> {

  private FamilyTree<T> tree;
  private FTService fts;

  private boolean controllerOn = true;
  private UserInput ui = new UserInput();
  private UserMenu um = new UserMenu();
  private FileWorker<T> fw = new FileWorker<T>();

  public Controller(FamilyTree<T> familyTree) {
    this.tree = familyTree;
    this.fts = new FTService<T>(tree);
  }

  public boolean getControllerStatus() {
    return controllerOn;
  }

  public void startControl() {
    um.showMenu();
    switch (ui.getString()) {
      case "1":
        um.textBeforeShowHumans();
        tree.showHumans();
        selectSortingMethod();
        break;

      case "2":
        um.askFullName();
        String fullName = ui.getString() + " " + ui.getString();
        Map.Entry<Integer, T> personWithId = tree.searchByName(fullName);
        if (personWithId.getValue() != null)
          um.showInfo(personWithId.getValue().getInfo());
        else
          um.humanNotFound();
        break;

      case "3":
        createHuman(tree);
        tree.showHumans();
        break;

      case "4":
        fw.save(tree);
        break;

      case "5":
        System.out.println("Вы точно хотите перезаписать текущее дерево? (y/n)");
        if (checkAnswer(ui.getString())) {
          tree.clearTree();
          tree = fw.load();
        }
        break;

      case "6":
        this.controllerOn = false;
        ui.closeInput();
        break;

      default:
        System.out.println("Выбран недействительный пункт меню");
        break;
    }
    // return tree;
  }

  public void createHuman(FamilyTree<T> familyTree) {
    um.dialogCreateHuman("askName");
    String fullName = ui.getString() + " " + ui.getString();
    um.dialogCreateHuman("askGender");
    String gender = ui.getString().toLowerCase();
    if (gender.equals("ж"))
      gender = "Женский";
    else
      gender = "Мужской";

    um.dialogCreateHuman("askParent");
    Map<Integer, T> availableMothers = familyTree.chooseParent("женский");
    Human parentMother = availableMothers.get(ui.getInt());

    um.dialogCreateHuman("askParent");
    Map<Integer, T> availableFathers = familyTree.chooseParent("мужской");
    Human parentFather = availableFathers.get(ui.getInt());

    familyTree.addHuman((T) new Human(fullName, gender, parentMother, parentFather));
  }

  public void selectSortingMethod() {
    um.textAskToSort();
    switch (ui.getString()) {
      case "1":
        um.showHumanList(fts.sortByName());
        break;

      case "2":
        um.showHumanList(fts.sortByNumberOfChildren());
        break;

      case "3":
        break;

      default:
        um.textIncorrectInput();
        break;
    }
  }

  public boolean checkAnswer(String answer) {
    return answer.toLowerCase().equals("y") ? true : false;
  }
}
