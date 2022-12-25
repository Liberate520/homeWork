package src.FileProcessing;

import java.io.Serializable;

import src.Entities.FamilyTree;
import src.Entities.Human;

public interface SaveLoadable {
  void save(Serializable serializable);

  FamilyTree<? extends Human> load(String path);

  FamilyTree<? extends Human> load();
}
