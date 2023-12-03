package homeWork.src.model.writer;

import homeWork.src.model.tree.FamilyTree;

import java.io.Serializable;
import java.util.List;

public interface Writable {
    boolean save(FamilyTree tree);
    Object read();
}
