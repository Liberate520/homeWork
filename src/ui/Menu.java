package ui;

import ui.commands.Command;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private List<Command> commands;

    public Menu(ConsoleUI console) {
        commands = new ArrayList<>();
        this.commands = commands;
    }

    public void execute(int choice) {
        commands.get(choice - 1).execute();
    }

    public String print() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < commands.size(); i++) {
            builder.append(i + 1)
                    .append(") ")
                    .append(commands.get(i).getDescription());
        }
        return builder.toString();
    }
}
