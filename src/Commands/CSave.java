package Commands;

import Interfaces.ICommands;
import Class.Utils;

import java.util.Scanner;

public class CSave implements ICommands {

    @Override
    public String info() {
        return "save - сохранение в файл";
    }

    @Override
    public String getName() {
        return "save";
    }

    @Override
    public void task(Scanner scanner, Utils utils) {
        utils.getFamilyTree().save("Class.FamilyTree.txt");
    }
}
