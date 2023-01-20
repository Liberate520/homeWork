package DZ1.mainMenuCommands;

import DZ1.UI.FamilyTreeUI;

public class Command_ClearTree implements Option {

    FamilyTreeUI familyTreeUI;

    public Command_ClearTree(FamilyTreeUI familyTreeUI) {
        this.familyTreeUI = familyTreeUI;
    }

    @Override
    public void execute() {
        familyTreeUI.clearTree();
    }

    @Override
    public String discription() {
        return "Очистить дерево";
    }
}
