package SaveOrRead;

import tree.FamilyTree;

public interface Interf<E> {
    FamilyTree loadFile(String str);
    void saveFile(FamilyTree familyTree, String str);
}