package Homework.model.Tree.FileMethods;

import java.io.Serializable;

public interface Writable {
    boolean saveAllInFile(Serializable serializable, String filePath);
    Object read(String filePath);

}
