package FamilyTree.Tree.FileHander;

import FamilyTree.Tree.HumanGroup.Service;

import java.io.Serializable;

public interface Writable {
    boolean save(Serializable serializable, String filePath);

    Object read(String filePath);
}