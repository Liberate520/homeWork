package src.Service.Commands;

import src.Entities.Human;
import src.Main.TreeService;
import src.Main.UserCommunication;

public class CommandLoad<T extends Human> extends Command<T> {
  public CommandLoad(TreeService<T> fts, UserCommunication<T> uc) {
    super(fts, uc);
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
