package DZ1.mainMenuCommands;

import java.io.FileNotFoundException;
import java.io.IOException;

import DZ1.UI.FamilyTreeUI;

public class Command_LoadTree implements Option {

    FamilyTreeUI familyTreeUI;

    public Command_LoadTree(FamilyTreeUI familyTreeUI) {
        this.familyTreeUI = familyTreeUI;
    }

    @Override
    public void execute() throws FileNotFoundException, ClassNotFoundException, IOException {
        familyTreeUI.loadTree();
    }

    @Override
    public String discription() {
        return "Загрузить дерево из файла";
    }
}