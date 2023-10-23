package homeWork3.ui;

import homeWork3.core.infrastructure.SortByAge;
import homeWork3.core.infrastructure.SortByName;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Options> commands;
    private Console console;

    public Menu(Console console) {
        this.console = console;
        commands = new ArrayList<>();
        commands.add(new addHuman(console));
        commands.add(new PrintFamily(console));
        commands.add(new SearchHuman(console));
        commands.add(new SortByName(console));
        commands.add(new SortByAge(console));
        commands.add(new Exit(console));
    }

    void execute(int num) {
        Options options = commands.get(num - 1);
        options.execute();
    }

    public String printMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nМеню\n");
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).details());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public Console getConsole() {
        return console;
    }

}