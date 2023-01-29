package Menu;

import Interface.FamilyTreeUI;

public class Structure_sortTree implements Select {

    FamilyTreeUI familyTreeUI;

    public Structure_sortTree(FamilyTreeUI familyTreeUI) {
        this.familyTreeUI = familyTreeUI;
    }

    @Override
    public void execute() {
        familyTreeUI.treeSort();
    }

    @Override
    public String discription() {
        return "Сортировка";
    }
}
