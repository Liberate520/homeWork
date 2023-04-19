package Tree.interfaces;

import java.io.IOException;
import java.io.Serializable;

import Tree.FamilyTree;

public interface Writable {

    void save(Serializable serializable) throws IOException;

    FamilyTree read() throws IOException, ClassNotFoundException;

}
