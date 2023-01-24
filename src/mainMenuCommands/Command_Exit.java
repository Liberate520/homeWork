package DZ1.mainMenuCommands;

import DZ1.UI.FamilyTreeUI;

public class Command_Exit implements Option {

    FamilyTreeUI familyTreeUI;

    public Command_Exit(FamilyTreeUI familyTreeUI) {
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
