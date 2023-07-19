package ru.gb.family_tree.view;

import ru.gb.family_tree.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;

    public MainMenu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new GetTreeInfo(consoleUI));
        commandList.add(new AddHuman(consoleUI));
        commandList.add(new AddKid(consoleUI));
        commandList.add(new AddParent(consoleUI));
        commandList.add(new AddPartner(consoleUI));
        commandList.add(new SortByName(consoleUI));
        commandList.add(new SortBYAge(consoleUI));
        commandList.add(new SortByBirthday(consoleUI));
        commandList.add(new SearchHuman(consoleUI));
        commandList.add(new SaveInFile(consoleUI));
        commandList.add(new LoadFromFile(consoleUI));
        commandList.add(new Finish(consoleUI));
    }

    public int getSize() {
        return commandList.size();
    }

    public String menu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice) {
        Command command = commandList.get(choice - 1);
        command.execute();
        System.out.println("  <><><><><><><><><><><><>");
    }
}