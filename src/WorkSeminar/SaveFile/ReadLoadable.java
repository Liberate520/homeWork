package WorkSeminar.SaveFile;

import java.io.Serializable;

public interface ReadLoadable {
    void saveFile(String path, Serializable serializable);
    Object loadFile(String path);
}
