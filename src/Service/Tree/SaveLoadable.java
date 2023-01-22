package src.Service.Tree;

import java.io.IOException;

public interface SaveLoadable {
  void save() throws IOException;

  Object load(String path) throws Exception;

  Object load() throws Exception;
}
