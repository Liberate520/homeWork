package src.FileProcessing;

import java.io.IOException;
import java.io.Serializable;

import src.Entities.FamilyTree;
import src.Entities.Human;

public interface SaveLoadable {
  void save(Serializable serializable) throws IOException;

  FamilyTree<? extends Human> load(String path) throws Exception;

  FamilyTree<? extends Human> load() throws Exception;
}
