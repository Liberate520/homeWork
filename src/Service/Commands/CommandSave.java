package src.Service.Commands;

import src.Entities.Human;
import src.Main.TreeService;
import src.Main.UserCommunication;

public class CommandSave<T extends Human> extends Command<T> {
  public CommandSave(TreeService<T> fts, UserCommunication<T> uc) {
    super(fts, uc);
  }

  @Override
  public void execute() {
    uc.saveAction(fts.save());
  }

  @Override
  public String description() {
    return "Сохранить текущее дерево в файл";
  }

}
