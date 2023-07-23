package family_tree.model;

import family_tree.model.human.Human;

import java.io.Serializable;

public class ReportableFamilyTree implements Reportable<FamilyTree>, Serializable {
    @Override
    public String getInfo(FamilyTree familyTree) {
        return "{ items: \n"
                + familyTree.getItemsInfo()
                + ",\nmarriages: \n"
                + familyTree.getMarriagesInfo()
                + "\n}";
    }
}
