package src.Main;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import src.FTService;
import src.Entities.FamilyTree;
import src.Entities.Human;
import src.FileProcessing.FileWorker;

public class Controller<T extends Human> {

  private FamilyTree<T> tree;
  private FTService<T> fts;

  private boolean controllerOn = true;
  private UserInput ui = new UserInput();
  private UserMenu<T> um = new UserMenu<T>();
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
        um.showHumans(tree.getAllHumans());
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
        um.showHumans(tree.getAllHumans());
        break;

      case "4":
        try {
          fw.save(tree);
          um.textActionWithFile("save");
        } catch (IOException e) {
          e.printStackTrace();
          um.textFailureFileAction("save");
        }
        break;

      case "5":
        um.askReplaceTree();
        if (checkAnswer(ui.getString())) {
          Map<Integer, T> backupTree = new HashMap<Integer, T>();
          backupTree.putAll(tree.getAllHumans());
          tree.clearTree();
          try {
            tree = fw.load();
            um.textActionWithFile("load");
          } catch (Exception e) {
            e.printStackTrace();
            um.textFailureFileAction("load");
            tree.getAllHumans().putAll(backupTree);
          }
        }
        break;

      case "q":
        this.controllerOn = false;
        ui.closeInput();
        break;

      default:
        um.textIncorrectInput();
        break;
    }
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
    // ^ Type safety: Unchecked cast from Human to TJava(16777761)
    // Как можно исправить замечания, не заглушая принудительно?

  }

  private void selectSortingMethod() {
    um.textAskToSort();
    switch (ui.getString()) {
      case "1":
        um.showHumanList(fts.sortByName());
        break;

      case "2":
        um.showHumanList(fts.sortByNumberOfChildren());
        break;

      case "q":
        break;

      default:
        um.textIncorrectInput();
        break;
    }
  }

  private boolean checkAnswer(String answer) {
    return answer.toLowerCase().equals("y") ? true : false;
  }
}
