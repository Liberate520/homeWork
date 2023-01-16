package DZ1.command;

import DZ1.app.FamilyTreeUI;

public class Command_ShowAllTree implements Option {

    FamilyTreeUI familyTreeUI = new FamilyTreeUI();

    public Command_ShowAllTree(FamilyTreeUI familyTreeUI) {
        this.familyTreeUI = familyTreeUI;
    }

    @Override
    public void execute() {
        familyTreeUI.showAllTree();
    }

    @Override
    public String discription() {
        return "Вывести на экран всех людей из дерева";
    }
}
