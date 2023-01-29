package Menu;

import Interface.FamilyTreeUI;

public class Structure_exit implements Select {
    FamilyTreeUI familyTreeUI;

    public Structure_exit(FamilyTreeUI familyTreeUI) {
        this.familyTreeUI = familyTreeUI;
    }

    @Override
    public void execute() {
        familyTreeUI.exit();
    }

    @Override
    public String discription() {
        return "Выход";
    }
}
