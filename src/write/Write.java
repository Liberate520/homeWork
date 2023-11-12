package HomeWork.familyTree.homeWork22_10_23.src.write;

import HomeWork.familyTree.homeWork22_10_23.src.tree.FamilyTree;

import java.io.Serializable;

public interface Write {
    void writeObject(Serializable serializable, String filePath);
    Object readObject(String filePath);
}
