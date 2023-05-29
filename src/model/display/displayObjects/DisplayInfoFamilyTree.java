package java_oop_homeWork.src.model.display.displayObjects;

import java_oop_homeWork.src.model.FamilyTree;
import java_oop_homeWork.src.model.display.DisplayInfo;
import java_oop_homeWork.src.model.display.displayFields.familyTree.FamilyTreeCountKins;
import java_oop_homeWork.src.model.display.displayFields.familyTree.FamilyTreeName;

public class DisplayInfoFamilyTree extends DisplayObject{
    public DisplayInfoFamilyTree(DisplayInfo displayInfo, FamilyTree familyTree) {
        super(displayInfo);
        fields.add(new FamilyTreeName("", familyTree.getName()));
        fields.add(new FamilyTreeCountKins("", familyTree.getFamily().size()));
    }
}
