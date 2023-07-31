package homeWork.family_tree.writer;

import java.io.Serializable;

public interface Writable {
    default boolean save(Serializable serializable, String filePath){
        return false;
    }
    Object read(String filePath);
}
