package FamilyTree.model.Saver;

import FamilyTree.model.FT.FamTree;
import FamilyTree.model.HR.Human;

public interface Writable {
//    boolean save(Serializable saveStream, String savePath);
//    Object load(String savePath);

    boolean save(FamTree<Human> activeTree);
    FamTree<Human> load();
    void setSavePath(String savePath);
}
