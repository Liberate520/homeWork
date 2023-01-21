package src.Service.Commands;

import src.Entities.Human;
import src.Main.TreeService;
import src.Main.UserCommunication;

public class CommandShowHumans<T extends Human> extends Command<T> {
  public CommandShowHumans(TreeService<T> fts, UserCommunication<T> uc) {
    super(fts, uc);
  }

  @Override
  public String description() {
    return "Показать всех людей";
  }

  @Override
  public void execute() {
    uc.showHumansFromTree(fts.getHumans());
  }

}
