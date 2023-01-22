package src.Service.Commands;

import src.Entities.Human;
import src.Main.TreeService;
import src.Main.UserCommunication;

public class CommandLoad<T extends Human> implements Executable {
  private TreeService<T> fts;
  private UserCommunication<T> uc;

  public CommandLoad(TreeService<T> fts, UserCommunication<T> uc) {
    this.fts = fts;
    this.uc = uc;
  }

  @Override
  public void execute() {
    fts.createBackup();
    fts.clearTree();
    boolean success = fts.load();
    uc.loadAction(success);
    if (!success)
      fts.restoreBackup();
  }

  @Override
  public String description() {
    return "Загрузить дерево из файла";
  }

}
