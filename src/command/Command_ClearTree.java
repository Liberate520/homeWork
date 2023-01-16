package DZ1.command;

import DZ1.app.FamilyTreeUI;

public class Command_ClearTree implements Option {

    FamilyTreeUI familyTreeUI = new FamilyTreeUI();

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
