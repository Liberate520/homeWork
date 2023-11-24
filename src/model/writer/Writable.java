package model.writer;

import model.familyTree.FamilyTree;

public interface Writable {
    void save (FamilyTree familyTree);
    FamilyTree load ();
}
