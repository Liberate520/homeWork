package view;

import java.util.Map;
import java.util.TreeMap;

import view.operations.*;

public class Menu {
    private TreeMap<String, Options> commands;
    private ConsoleUI consoleUI;

    public Menu(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        this.commands = new TreeMap<>();
        this.commands.put("x", new Exit(consoleUI));
        this.commands.put("1", new PrintAll(consoleUI));
        this.commands.put("2", new AddRec(consoleUI));
        this.commands.put("3", new DelRec(consoleUI));
        this.commands.put("l", new Load(consoleUI));
        this.commands.put("s", new Save(consoleUI));
    }

    public String printMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append(" выберите операцию:\n");
        for (Map.Entry<String, Options> item: this.commands.entrySet()) {
            sb.append(item.getKey());
            sb.append(" - ");
            sb.append(item.getValue().optionName());
            sb.append("    ");
        }
        return sb.toString();
    }

    public void execute(String opt) {
        if (commands.containsKey(opt)) {
            Options option = commands.get(opt);
            option.execute();
        }
    }
}
