package DZ1.mainMenuCommands;

import java.io.IOException;

import DZ1.UI.FamilyTreeUI;

public class Command_SaveTree implements Option {

    FamilyTreeUI familyTreeUI;

    public Command_SaveTree(FamilyTreeUI familyTreeUI) {
        this.familyTreeUI = familyTreeUI;
    }

    @Override
    public void execute() throws IOException {
        familyTreeUI.saveTree();
    }

    @Override
    public String discription() {
        return "Сохранить дерево в файл";
    }
}
