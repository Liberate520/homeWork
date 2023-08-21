package Model.FamilyTree;

import Model.BaseCharacter.BaseCharacter;

public interface Writable{
    boolean save(FamilyTree<BaseCharacter> familyTree, String filePath);
    Object read(String filePath);

}