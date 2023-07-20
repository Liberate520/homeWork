package org.genealogy.view;

import org.genealogy.view.commands.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;

    public MainMenu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new AddHuman(consoleUI));
        commandList.add(new AddDateOfBirth(consoleUI));
        commandList.add(new AddDateOfDeath(consoleUI));
        commandList.add(new GetHumanInfo(consoleUI));
        commandList.add(new SortByName(consoleUI));
        commandList.add(new SortByAge(consoleUI));
        commandList.add(new AddGender(consoleUI));
        commandList.add(new AddChild(consoleUI));
        commandList.add(new AddExtraInfo(consoleUI));
        commandList.add(new SaveTreeToFile(consoleUI));
        commandList.add(new LoadTreeFromFile(consoleUI));
        commandList.add(new Finish(consoleUI));
    }

    public String menu(){
        System.out.println("Меню:");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice) throws IOException, ClassNotFoundException {
        Command command = commandList.get(choice);
        command.execute();
    }

    public int getSize(){
        return commandList.size();
    }
}
