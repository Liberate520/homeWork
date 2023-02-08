package src.Service.Commands;

import java.util.Map;

import src.Entities.Human;
import src.Main.TreeService;
import src.Main.UserCommunication;

public class CommandAdd<T extends Human> extends Command<T> {
  public CommandAdd(TreeService<T> fts, UserCommunication<T> uc) {
    super(fts, uc);
  }

  @Override
  public void execute() {
    uc.showHumansFromTree(fts.getHumans());

    String fullName = uc.askFullName();
    String gender = uc.askGender();

    Map<Integer, T> availableParents = fts.chooseParent("женский");
    int numberOfParent = uc.chooseParent(availableParents);
    T mother = availableParents.get(numberOfParent);

    availableParents = fts.chooseParent("мужской");
    numberOfParent = uc.chooseParent(availableParents);
    T father = availableParents.get(numberOfParent);

    fts.createHuman(fullName, gender, mother, father);
  }

  @Override
  public String description() {
    return "Добавить нового человека";
  }

}
