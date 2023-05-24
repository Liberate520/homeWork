package model.data;

import FamilyTree.FamilyTree;

import java.io.IOException;
import java.io.Serializable;

public interface Writable {
    void save(Serializable serializable, String fileName);
    FamilyTree load(String fileName);
}
