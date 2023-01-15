package src.Service.Commands;

import src.Entities.Human;
import src.Main.FTService;
import src.Main.UserCommunication;

public class CommandSortName<T extends Human> extends Command<T> {
  public CommandSortName(FTService<T> fts, UserCommunication<T> uc) {
    super(fts, uc);
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
