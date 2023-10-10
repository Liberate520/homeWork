package View;

import java.util.ArrayList;
import java.util.List;

import View.Commands.*;

public class Menu {

    private List<Command> commands;

    public Menu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new AddHuman(consoleUI));
        commands.add(new AddHumanParent(consoleUI));
        commands.add(new GetHumanList(consoleUI));
        commands.add(new SortHumanByFirstName(consoleUI));
        commands.add(new SortHumanByLastName(consoleUI));
        commands.add(new SortHumanByBornDate(consoleUI));
        commands.add(new SortHumanByAge(consoleUI));
        commands.add(new SaveHumanTree(consoleUI));
        commands.add(new Finish(consoleUI));
    }
    public String menu() {
        StringBuilder sb = new StringBuilder();
        sb.append("Menu \n");
        for (int i = 0; i < commands.size(); i++) {
            Command c = commands.get(i);
            sb.append(i + 1);
            sb.append(". ");
            sb.append(c.getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void choise(int id) {
        Command c = commands.get(id -1);
        c.execute();
    }


    public int size(int choise) {
        return commands.size();
    }
}

