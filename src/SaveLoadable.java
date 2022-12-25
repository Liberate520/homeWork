package src;

import java.io.Serializable;

public interface SaveLoadable {
  void save(Serializable serializable);

  FamilyTree<? extends Human> load(String path);

  FamilyTree<? extends Human> load();
}
