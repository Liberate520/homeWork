package FamilyTree;

import FamilyTree.FamilyTree;

public interface Writable {

    void save(FamilyTree tree);
    FamilyTree read ();
}
