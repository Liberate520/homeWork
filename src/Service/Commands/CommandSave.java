package src.Service.Commands;

import java.io.IOException;

import src.Entities.Human;
import src.Main.FTService;
import src.Main.UserCommunication;

public class CommandSave<T extends Human> implements Executable {
  private FTService<T> fts;
  private UserCommunication<T> uc;

  public CommandSave(FTService<T> fts, UserCommunication<T> uc) {
    this.fts = fts;
    this.uc = uc;
  }

  @Override
  public void execute() {
    try {
      fts.save();
      uc.saveAction(true);
    } catch (IOException e) {
      e.printStackTrace();
      uc.loadAction(false);
    }
  }

  @Override
  public String description() {
    return "Сохранить текущее дерево в файл";
  }

}
