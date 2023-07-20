package Model.Write;

import Model.FamilyTree.FamilyTree;

import java.io.Serializable;

public interface WriteObject {
    void write(Serializable inputObject, String fileName);
    FamilyTree read(String fileName);

}
