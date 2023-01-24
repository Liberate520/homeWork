package DZ1.mainMenuCommands;

import DZ1.UI.FamilyTreeUI;

public class Command_SearchByName implements Option {

    FamilyTreeUI familyTreeUI;

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
