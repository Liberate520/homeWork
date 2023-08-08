package Model.FileHandler;


import Model.FamilyTree.FamilyTree.EntityTree;

import java.io.Serializable;

public interface Writable {
    void writeToFile(Serializable serializable, String path);

    EntityTree readFromFile(String path);
}
