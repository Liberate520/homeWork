package src.Service.Commands;

import src.Entities.Human;
import src.Main.FTService;
import src.Main.UserCommunication;

public class CommandShowHumans<T extends Human> extends Command<T> {
  public CommandShowHumans(FTService<T> fts, UserCommunication<T> uc) {
    super(fts, uc);
  }

  @Override
  public String description() {
    return "Показать всех людей";
  }

  @Override
  public void execute() {
    uc.showHumansFromTree(fts.getAllHumans());
  }

}
