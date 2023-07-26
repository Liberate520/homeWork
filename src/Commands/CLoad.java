package Commands;

import Interfaces.ICommands;
import Class.Utils;

import java.util.Scanner;

public class CLoad implements ICommands {
    @Override
    public String info() {
        return "load - загрузка из файла";
    }

    @Override
    public String getName() {
        return "load";
    }

    @Override
    public void task(Scanner scanner, Utils utils) {
        utils.getFamilyTree().load("Class.FamilyTree.txt");
    }
}
