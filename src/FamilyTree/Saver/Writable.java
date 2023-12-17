package FamilyTree.Saver;

import java.io.Serializable;

public interface Writable {
    boolean save(Serializable saveStream, String savePath);
    Object load(String savePath);

//    void setSavePath(String savePath);
}
