package view;

import view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;

    public MainMenu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new PrintTree(consoleUI));
        commandList.add(new PrintTreeConnections(consoleUI));
        commandList.add(new SortByAge(consoleUI));
        commandList.add(new SortByName(consoleUI));
        commandList.add(new ShowConnections(consoleUI));
        commandList.add(new AddPerson(consoleUI));
        commandList.add(new PutConnectionTrue(consoleUI));
        commandList.add(new PutConnectionFalse(consoleUI));
        commandList.add(new Read(consoleUI));
        commandList.add(new Write(consoleUI));
        commandList.add(new Finish(consoleUI));
    }

    public void execute(String choiceNum) {
        int choice = Integer.parseInt(choiceNum) - 1;
        Command command = commandList.get(choice);
        command.execute();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Command command :
                commandList) {
            sb.append(commandList.indexOf(command) + 1);
            sb.append(". ");
            sb.append(command.getDescription()).append("\n");
        }
        return sb.toString();
    }
}
