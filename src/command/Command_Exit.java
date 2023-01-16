package DZ1.command;

import DZ1.app.FamilyTreeUI;

public class Command_Exit implements Option {

    FamilyTreeUI familyTreeUI = new FamilyTreeUI();

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
