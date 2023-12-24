package FamilyTree.model.Saver;

import FamilyTree.model.FT.FamTree;
import FamilyTree.model.HR.Human;

public interface Writable {

    boolean save(FamTree<Human> activeTree);
    FamTree<Human> read();
    void setSavePath(String savePath);

//    boolean save(Serializable saveStream, String savePath);
//    Object load(String savePath);
}
