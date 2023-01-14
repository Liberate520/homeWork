package src.Service.Commands;

import src.Entities.Human;
import src.Main.FTService;
import src.Main.UserCommunication;

public class CommandLoad<T extends Human> implements Executable {
  private FTService<T> fts;
  private UserCommunication<T> uc;

  public CommandLoad(FTService<T> fts, UserCommunication<T> uc) {
    this.fts = fts;
    this.uc = uc;
  }

  @Override
  public void execute() {
    fts.createBackup();
    fts.clearTree();
    try {
      fts.load();
      uc.loadAction(true);
    } catch (Exception e) {
      e.printStackTrace();
      uc.loadAction(false);
      fts.restoreFromBackup();
    }
  }

  @Override
  public String description() {
    return "Загрузить дерево из файла";
  }

}
