package save;

import human.Human;
import tree.FamilyTree;

import java.io.Serializable;

public interface Writeable {
    boolean save(Serializable serializable, String path);

   Serializable load(String path);
}
