package Commands;

import Interfaces.ICommands;
import Class.Utils;
import Class.Human;

import java.util.List;
import java.util.Scanner;

public class CFindParents implements ICommands {
    @Override
    public String info() {
        return "findParents - поиск родителей по id человека";
    }

    @Override
    public String getName() {
        return "findParents";
    }

    @Override
    public void task(Scanner scanner, Utils utils) {
        System.out.println("Введите ID: ");
        String input = scanner.nextLine();
        List<Human> parents = utils.FindParents(Integer.parseInt(input));
        for (Human human : parents) {
            System.out.println(human);
        }
    }
}
