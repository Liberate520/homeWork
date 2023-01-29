package Menu;

import Interface.FamilyTreeUI;

public class Structure_clearTree implements Select {

    FamilyTreeUI familyTreeUI;

    public Structure_clearTree(FamilyTreeUI familyTreeUI) {
        this.familyTreeUI = familyTreeUI;
    }

    @Override
    public void execute() {
        familyTreeUI.clearTree();
    }

    @Override
    public String discription() {
        return "Очистка";
    }
}