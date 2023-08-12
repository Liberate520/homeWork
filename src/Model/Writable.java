package Model;

import Model.FamilyTree;
import Model.HouseHold;

public interface Writable{
    boolean save(FamilyTree<HouseHold> familyTree, String filePath);
    Object read(String filePath);

}