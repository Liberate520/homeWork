package src.Main;

import java.io.IOException;
import java.util.Map;

import src.Entities.FamilyTree;
import src.Entities.Human;

public class Controller<T extends Human> {

  private boolean controllerOn = true;
  private FTService<T> fts;
  private UserCommunication<T> uc;

  public Controller(FamilyTree<T> familyTree) {
    this.fts = new FTService<T>(familyTree);
    this.uc = new UserCommunication<T>();
  }

  /**
   * Проверка статуса контроллера, для выбора дальнейшего действия: продолжения
   * или завершения работы
   * 
   * @return boolean статус контроллера о продолжении работы
   */
  public boolean getControllerStatus() {
    return controllerOn;
  }

  /**
   * Запуск работы контроллера
   */
  public void startControl() {
    switch (uc.launchMenu()) {
      case "1":
        uc.showHumansFromTree(fts.getAllHumans());
        selectSortMethod();
        break;

      case "2":
        Map.Entry<Integer, T> personWithId = fts.searchByName(uc.askFullName());
        uc.showMoreHumansInfo(personWithId);
        break;

      case "3":
        uc.showHumansFromTree(fts.getAllHumans());

        String fullName = uc.askFullName();
        String gender = uc.askGender();

        Map<Integer, T> availableParents = fts.chooseParent("женский");
        int numberOfParent = uc.chooseParent(availableParents);
        T mother = availableParents.get(numberOfParent);

        availableParents = fts.chooseParent("мужской");
        numberOfParent = uc.chooseParent(availableParents);
        T father = availableParents.get(numberOfParent);

        fts.createHuman(fullName, gender, mother, father);
        break;

      case "4":
        try {
          fts.save();
          uc.saveAction(true);
        } catch (IOException e) {
          e.printStackTrace();
          uc.loadAction(false);
        }
        break;

      case "5":
        if (checkAnswer(uc.replaceTree())) {
          fts.createBackup();
          fts.clearTree();
          try {
            fts.load();
            uc.loadAction(true);
          } catch (Exception e) {
            e.printStackTrace();
            uc.loadAction(false);
            fts.restoreFromBackup();
          }
        }
        break;

      case "q":
        this.controllerOn = false;
        uc.closeInput();
        break;

      default:
        uc.incorrectInput();
        break;
    }
  }

  /**
   * Выбор метода сортировки списка людей
   */
  private void selectSortMethod() {
    switch (uc.askToSort()) {
      case "1":
        uc.showSortedHumanList(fts.sortByName());
        break;

      case "2":
        uc.showSortedHumanList(fts.sortByNumberOfChildren());
        break;

      case "q":
        break;

      default:
        uc.printIncorrectInput();
        break;
    }
  }

  /**
   * Проверка ответа пользователя
   * 
   * @param answer
   * @return boolean утвердительный ли ответ пользователя
   */
  private boolean checkAnswer(String answer) {
    return answer.toLowerCase().equals("y") ? true : false;
  }
}
