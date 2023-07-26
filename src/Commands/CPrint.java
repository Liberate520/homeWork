package Commands;

import Interfaces.ICommands;
import Class.Utils;

import java.util.Scanner;

public class CPrint implements ICommands {
    @Override
    public String info() {
        return "print - вывод гениалогического дерева";
    }

    @Override
    public String getName() {
        return "print";
    }

    @Override
    public void task(Scanner scanner, Utils utils) {
        utils.print();
    }
}
