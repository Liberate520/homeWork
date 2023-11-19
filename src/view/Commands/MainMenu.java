package view.Commands;

import view.Commands.AddHuman;
import view.Commands.Commands;
import view.ConsoleUI;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Commands> commandsList;

    public MainMenu(ConsoleUI consoleUI) {
        this.commandsList = new ArrayList<>();
        this.commandsList.add(new AddHuman(consoleUI));
        this.commandsList.add(new AddChildren(consoleUI));
        this.commandsList.add(new ReadFile(consoleUI));
        this.commandsList.add(new WriteFile(consoleUI));
        this.commandsList.add(new SortByName(consoleUI));
        this.commandsList.add(new SortByAge(consoleUI));
        this.commandsList.add(new SortById(consoleUI));
        this.commandsList.add(new Finish((consoleUI)));
    }

    public String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandsList.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commandsList.get(i).description);
            stringBuilder.append("\n");
        }
        stringBuilder.setLength(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    public void execute(int choice){
        Commands command = commandsList.get(choice);
        command.execute();
    }

    public int getSize(){
        return commandsList.size();
    }
}
