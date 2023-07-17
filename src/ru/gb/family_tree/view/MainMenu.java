package ru.gb.family_tree.view;

import java.util.ArrayList;
import java.util.List;
import ru.gb.family_tree.view.commands.*;

public class MainMenu {
    private List<Command> commandList;

    public MainMenu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new AddHuman(consoleUI));
        commandList.add(new GetInfo(consoleUI));
        commandList.add(new SortByFullName(consoleUI));
        commandList.add(new SortByAge(consoleUI));
        commandList.add(new SaveFile(consoleUI));
        commandList.add(new WriteFile(consoleUI));
        commandList.add(new Finish(consoleUI));
    }

    public String menu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(".");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");

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
