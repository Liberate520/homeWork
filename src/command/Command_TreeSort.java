package DZ1.command;

import DZ1.app.FamilyTreeUI;

public class Command_TreeSort implements Option {

    FamilyTreeUI familyTreeUI = new FamilyTreeUI();

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