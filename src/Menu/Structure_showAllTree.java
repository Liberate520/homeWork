package Menu;

import Interface.FamilyTreeUI;

public class Structure_showAllTree implements Select {

    FamilyTreeUI familyTreeUI;

    public Structure_showAllTree(FamilyTreeUI familyTreeUI) {
        this.familyTreeUI = familyTreeUI;
    }

    @Override
    public void execute() {
        familyTreeUI.showAllTree();
    }

    @Override
    public String discription() {
        return "Вывод на экран всех людей";
    }
}