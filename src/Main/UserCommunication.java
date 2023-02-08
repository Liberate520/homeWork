package src.Main;

import java.util.List;
import java.util.Map;

import src.Entities.Human;
import src.Service.Commands.Executable;
import src.Service.UserCommunication.UserInput;
import src.Service.UserCommunication.UserMenu;

public class UserCommunication<T extends Human> {
  private UserInput ui = new UserInput();
  private UserMenu<T> um = new UserMenu<T>();

  public String launchMenu(List<Executable> commands) {
    um.mainMenu(commands);
    return ui.getString();
  }

  public String getString() {
    return ui.getString();
  }

  public int getInt() {
    return ui.getInt();
  }

  public void showHumansFromTree(Map<Integer, T> humans) {
    um.textBeforeShowHumans();
    um.showHumans(humans);
  }

  public void showSortedHumanList(List<T> humanList) {
    um.showHumanList(humanList);
  }

  public void printIncorrectInput() {
    um.textIncorrectInput();
  }

  public String askFullName() {
    um.askFullName();
    return ui.getString() + " " + ui.getString();
  }

  public String askGender() {
    um.askGender();
    String gender = ui.getString().toLowerCase();
    if (gender.equals("ж"))
      gender = "Женский";
    else
      gender = "Мужской";
    return gender;
  }

  public int chooseParent(Map<Integer, T> availableParents) {
    availableParents.entrySet()
        .stream()
        .forEach(person -> System.out.println(person.getKey() + " - " +
            person.getValue()));

    return ui.getInt();
  }

  public void showMoreHumansInfo(Map.Entry<Integer, T> personWithId) {
    if (personWithId != null)
      um.showInfo(personWithId.getValue().getInfo());
    else
      um.humanNotFound();
  }

  public void saveAction(Boolean success) {
    um.textSaveAction(success);
  }

  public void loadAction(boolean success) {
    um.textLoadAction(success);
  }

  public String replaceTree() {
    um.askReplaceTree();
    return ui.getString();
  }

  public void closeInput() {
    ui.closeInput();
  }

  public void incorrectInput() {
    um.textIncorrectInput();
  }

}
