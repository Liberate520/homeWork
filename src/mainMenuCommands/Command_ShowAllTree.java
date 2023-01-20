package DZ1.mainMenuCommands;

import DZ1.UI.FamilyTreeUI;

public class Command_ShowAllTree implements Option {

    FamilyTreeUI familyTreeUI;

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
