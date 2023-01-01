package src.Service;

import java.io.IOException;

public interface SaveLoadable {
  void save() throws IOException;

  void load(String path) throws Exception;

  void load() throws Exception;
}
