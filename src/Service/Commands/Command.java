package src.Service.Commands;

import src.Entities.Human;
import src.Main.TreeService;
import src.Main.UserCommunication;

public abstract class Command<T extends Human> implements Executable {
  protected TreeService<T> fts;
  protected UserCommunication<T> uc;

  public Command(TreeService<T> fts, UserCommunication<T> uc) {
    this.fts = fts;
    this.uc = uc;
  }

}
