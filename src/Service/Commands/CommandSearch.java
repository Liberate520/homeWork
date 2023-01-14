package src.Service.Commands;

import java.util.Map;

import src.Entities.Human;
import src.Main.FTService;
import src.Main.UserCommunication;

public class CommandSearch<T extends Human> implements Executable {
  private FTService<T> fts;
  private UserCommunication<T> uc;

  public CommandSearch(FTService<T> fts, UserCommunication<T> uc) {
    this.fts = fts;
    this.uc = uc;
  }

  @Override
  public void execute() {
    Map.Entry<Integer, T> personWithId = fts.searchByName(uc.askFullName());
    uc.showMoreHumansInfo(personWithId);
  }

  @Override
  public String description() {
    return "Найти человека по имени и фамилии";
  }

}
