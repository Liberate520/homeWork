package writer;

import human.Human;
import tree.FamilyTree;
import tree.FamilyTreeItem;

import java.io.Serializable;
public interface Writable {
    boolean save(Serializable serializable, String filePath);
    Object read(String filePath);
}
