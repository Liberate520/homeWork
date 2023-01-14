package src.Service.Commands;

import src.Entities.Human;
import src.Main.FTService;
import src.Main.UserCommunication;

public class CommandShowHumans<T extends Human> implements Executable {
  private FTService<T> fts;
  private UserCommunication<T> uc;

  public CommandShowHumans(FTService<T> fts, UserCommunication<T> uc) {
    this.fts = fts;
    this.uc = uc;
  }

  @Override
  public String description() {
    return "Показать всех людей";
  }

  @Override
  public void execute() {
    uc.showHumansFromTree(fts.getAllHumans());
    // selectSortMethod();
  }

}
