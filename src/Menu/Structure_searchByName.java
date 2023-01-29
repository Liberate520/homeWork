package Menu;

import Interface.FamilyTreeUI;

public class Structure_searchByName implements Select {

    FamilyTreeUI familyTreeUI;

    public Structure_searchByName(FamilyTreeUI familyTreeUI) {
        this.familyTreeUI = familyTreeUI;
    }

    @Override
    public void execute() {
        familyTreeUI.searchByName();
    }

    @Override
    public String discription() {
        return "Поиск по имени";
    }
}