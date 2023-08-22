package home_work.view;

import java.util.ArrayList;
import java.util.List;

import home_work.view.command.AddHuman;
import home_work.view.command.Command;
import home_work.view.command.GetTree;

public class MainMenu {
    List<Command> commandList;

    public MainMenu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new AddHuman(consoleUI));
        commandList.add(new GetTree(consoleUI));
    }

    public String menu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int numCommand) {
        Command command = commandList.get(numCommand - 1);
        command.execute();
    }

    public int size() {
        return commandList.size();
    }
}
