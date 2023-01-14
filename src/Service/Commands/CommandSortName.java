package src.Service.Commands;

import src.Entities.Human;
import src.Main.FTService;
import src.Main.UserCommunication;

public class CommandSortName<T extends Human> implements Executable {
  private FTService<T> fts;
  private UserCommunication<T> uc;

  public CommandSortName(FTService<T> fts, UserCommunication<T> uc) {
    this.fts = fts;
    this.uc = uc;
  }

  @Override
  public void execute() {
    uc.showSortedHumanList(fts.sortByName());
  }

  @Override
  public String description() {
    return "Сортировка по имени";
  }

}
