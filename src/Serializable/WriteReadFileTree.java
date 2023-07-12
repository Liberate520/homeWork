package Serializable;

import java.io.Serializable;

public interface WriteReadFileTree {
    boolean save(Serializable serializable, String filePath);
    Object read(String filePath);
}
