package src.Main;

import java.util.ArrayList;
import java.util.List;

import src.Entities.FamilyTree;
import src.Entities.Human;
import src.Service.Commands.*;

public class Controller<T extends Human> {

  private boolean controllerOn = true;
  private FTService<T> fts;
  private UserCommunication<T> uc;
  private List<Executable> commandList;

  public Controller(FamilyTree<T> familyTree) {
    this.fts = new FTService<T>(familyTree);
    this.uc = new UserCommunication<T>();
    commandList = new ArrayList<>();

    commandList.add(new CommandShowHumans<>(fts, uc));
    commandList.add(new CommandSearch<>(fts, uc));
    commandList.add(new CommandAdd<>(fts, uc));
    commandList.add(new CommandSave<>(fts, uc));
    commandList.add(new CommandLoad<>(fts, uc));
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
    String userInput = uc.launchMenu(commandList);

    if (userInput.equals("q")) {
      this.controllerOn = false;
      uc.closeInput();
    } else {
      try {
        int choosenMenuPoint = Integer.parseInt(userInput);
        commandList.get(choosenMenuPoint).execute();
      } catch (NumberFormatException e) {
        uc.printIncorrectInput();
      } catch (IndexOutOfBoundsException e) {
        uc.printIncorrectInput();
      }
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
