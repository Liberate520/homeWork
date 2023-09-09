package model.fileOperations;

import java.io.Serializable;

public interface Writable {
    boolean save(Serializable serializable);
    Object read();
    void setFilePath(String filePath);
}
