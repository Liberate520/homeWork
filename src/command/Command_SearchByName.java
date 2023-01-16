package DZ1.command;

import DZ1.app.FamilyTreeUI;

public class Command_SearchByName implements Option {

    FamilyTreeUI familyTreeUI = new FamilyTreeUI();

    public Command_SearchByName(FamilyTreeUI familyTreeUI) {
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
