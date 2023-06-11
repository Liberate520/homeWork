package view.menu;

import view.ConsoleUI;
import view.menu.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;

    public MainMenu(ConsoleUI consoleUI) {
        this.commandList = new ArrayList<>();

        this.commandList.add(new AddRecord(consoleUI));
        this.commandList.add(new GetRecord(consoleUI));
        this.commandList.add(new GetParents(consoleUI));
        this.commandList.add(new GetAllRecord(consoleUI));
        this.commandList.add(new Finish(consoleUI));


    }

    public String printMenu() {
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
    }

    public int size() {
        return commandList.size();
    }


}
