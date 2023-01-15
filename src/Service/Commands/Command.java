package src.Service.Commands;

import src.Entities.Human;
import src.Main.FTService;
import src.Main.UserCommunication;

public abstract class Command<T extends Human> implements Executable {
  protected FTService<T> fts;
  protected UserCommunication<T> uc;

  public Command(FTService<T> fts, UserCommunication<T> uc) {
    this.fts = fts;
    this.uc = uc;
  }

}
