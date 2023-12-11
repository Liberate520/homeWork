package view;

import view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;

    public MainMenu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new AddCreature(consoleUI));
        commandList.add(new ShowNotInTree(consoleUI));
        commandList.add(new ShowInTree(consoleUI));
        commandList.add(new ShowAll(consoleUI));
        commandList.add(new ShowAllInfo(consoleUI));
        commandList.add(new SetChild(consoleUI));
        commandList.add(new Exit(consoleUI));
    }

    public String menu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append("\n");
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
        }
        return stringBuilder.toString();
    }

    public void execute(int choice) {
        Command command = commandList.get(choice - 1);
        command.execute();
    }

    public int getSize() {
        return commandList.size();
    }
}

