package src.Main;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import src.Entities.FamilyTree;
import src.Entities.Human;
import src.Service.FTService;

public class Controller<T extends Human> {

  private boolean controllerOn = true;
  private FTService<T> fts;
  private UserInput ui = new UserInput();
  private UserMenu<T> um = new UserMenu<T>();

  public Controller(FamilyTree<T> familyTree) {
    this.fts = new FTService<T>(familyTree);
  }

  public boolean getControllerStatus() {
    return controllerOn;
  }

  public void startControl() {
    um.showMenu();
    switch (ui.getString()) {
      case "1":
        um.textBeforeShowHumans();
        um.showHumans(fts.getAllHumans());
        selectSortingMethod();
        break;

      case "2":
        um.askFullName();
        String fullName = ui.getString() + " " + ui.getString();
        Map.Entry<Integer, T> personWithId = fts.searchByName(fullName);
        if (personWithId.getValue() != null)
          um.showInfo(personWithId.getValue().getInfo());
        else
          um.humanNotFound();
        break;

      case "3":
        createHuman();
        um.showHumans(fts.getAllHumans());
        break;

      case "4":
        try {
          fts.save();
          um.textActionWithFile("save");
        } catch (IOException e) {
          e.printStackTrace();
          um.textFailureFileAction("save");
        }
        break;

      case "5":
        um.askReplaceTree();
        if (checkAnswer(ui.getString())) {
          fts.createBackup();
          fts.clearTree();
          try {
            fts.load();
            um.textActionWithFile("load");
          } catch (Exception e) {
            e.printStackTrace();
            um.textFailureFileAction("load");
            fts.restoreFromBackup();
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

  public void createHuman() {
    um.dialogCreateHuman("askName");
    String fullName = ui.getString() + " " + ui.getString();
    um.dialogCreateHuman("askGender");
    String gender = ui.getString().toLowerCase();
    if (gender.equals("ж"))
      gender = "Женский";
    else
      gender = "Мужской";

    um.dialogCreateHuman("askParent");
    Map<Integer, T> availableMothers = fts.chooseParent("женский");
    T parentMother = availableMothers.get(ui.getInt());

    um.dialogCreateHuman("askParent");
    Map<Integer, T> availableFathers = fts.chooseParent("мужской");
    T parentFather = availableFathers.get(ui.getInt());

    fts.createHuman(fullName, gender, parentMother, parentFather);
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
