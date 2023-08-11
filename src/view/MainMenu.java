package view;

import view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;

    public MainMenu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new AddHuman(consoleUI));
        commandList.add(new AddChild(consoleUI));
        commandList.add(new Marry(consoleUI));
        commandList.add(new OutputInfo(consoleUI));
        commandList.add(new SortByName(consoleUI));
        commandList.add(new SortByBirthDay(consoleUI));
        commandList.add(new Save(consoleUI));
        commandList.add(new Load(consoleUI));
        commandList.add(new Exit(consoleUI));
    }

    public String menu() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<commandList.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        stringBuilder.append("Введите номер команды:");
        return stringBuilder.toString();
    }

    public void execute(int choice) {
        Command command = commandList.get(choice-1);
        command.execute();
    }

    public int getSize() {
        return commandList.size();
    }
}
