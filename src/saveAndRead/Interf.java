package saveAndRead;

import familyTree.FamilyTree;

public interface Interf<E> {
    FamilyTree loadFile(String str);
    void saveFile(FamilyTree familyTree, String str);
}
