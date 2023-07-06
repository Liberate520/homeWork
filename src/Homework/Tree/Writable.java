package Homework.Tree;

import java.io.Serializable;

public interface Writable {
    boolean saveAllInFile(Serializable serializable, String filePath);
    Object read(String filePath);

}
