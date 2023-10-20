package writer;

import familyTree.FamilyTree;

public interface Writable {
    void save (FamilyTree familyTree);
    void load ();
}
