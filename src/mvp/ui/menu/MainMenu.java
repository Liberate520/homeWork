package mvp.ui.menu;

import java.util.ArrayList;
import java.util.List;

import mvp.ui.ConsoleUI;
import mvp.ui.commands.*;

public class MainMenu {
    List<Command> commandList;

    public MainMenu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new AddNote(consoleUI));
        commandList.add(new GetNote(consoleUI));
        commandList.add(new GetAllNote(consoleUI));
        commandList.add(new End(consoleUI));
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
