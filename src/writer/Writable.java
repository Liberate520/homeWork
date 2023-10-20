package writer;

import familyTree.FamilyTree;

public interface Writable {
    void save (FamilyTree familyTree);
    FamilyTree load ();
}
