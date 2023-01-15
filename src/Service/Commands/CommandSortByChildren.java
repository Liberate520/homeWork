package src.Service.Commands;

import src.Entities.Human;
import src.Main.FTService;
import src.Main.UserCommunication;

public class CommandSortByChildren<T extends Human> extends Command<T> {
  public CommandSortByChildren(FTService<T> fts, UserCommunication<T> uc) {
    super(fts, uc);
  }

  @Override
  public void execute() {
    uc.showSortedHumanList(fts.sortByNumberOfChildren());
  }

  @Override
  public String description() {
    return "Сортировка по количеству детей";
  }

}
