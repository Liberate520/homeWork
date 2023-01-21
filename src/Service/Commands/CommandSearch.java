package src.Service.Commands;

import java.util.Map;

import src.Entities.Human;
import src.Main.TreeService;
import src.Main.UserCommunication;

public class CommandSearch<T extends Human> extends Command<T> {
  public CommandSearch(TreeService<T> fts, UserCommunication<T> uc) {
    super(fts, uc);
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
