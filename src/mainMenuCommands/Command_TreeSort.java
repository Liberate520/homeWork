package DZ1.mainMenuCommands;

import DZ1.UI.FamilyTreeUI;

public class Command_TreeSort implements Option {

    FamilyTreeUI familyTreeUI;

    public Command_TreeSort(FamilyTreeUI familyTreeUI) {
        this.familyTreeUI = familyTreeUI;
    }

    @Override
    public void execute() {
        familyTreeUI.treeSort();
    }

    @Override
    public String discription() {
        return "Соритровка дерева";
    }
}