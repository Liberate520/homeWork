package src.Service.TreeActions;

import java.io.IOException;

import src.Entities.FamilyTree;
import src.Entities.Human;
import src.Service.Tree.SaveLoadable;

public class TreeSaveLoad<T extends Human> extends TreeAction<T> implements SaveLoadable {

  public TreeSaveLoad(FamilyTree<T> tree) {
    super(tree);
  }

  @Override
  public void save() throws IOException {
    // TODO Auto-generated method stub

  }

  @Override
  public void load(String path) throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public void load() throws Exception {
    // TODO Auto-generated method stub

  }

}
