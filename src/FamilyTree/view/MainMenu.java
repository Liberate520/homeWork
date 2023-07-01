package FamilyTree.view;

import FamilyTree.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;
    public MainMenu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new GetFamilyTreeInfo(consoleUI));
        commandList.add(new GetByName(consoleUI));
        commandList.add(new AddPerson(consoleUI));
        commandList.add(new UpdatePerson(consoleUI));
        commandList.add(new SortByName(consoleUI));
        commandList.add(new SortByAge(consoleUI));
        commandList.add(new SaveTree(consoleUI));
        commandList.add(new LoadTree(consoleUI));
        commandList.add(new Finish(consoleUI));
    }

    public void printMenu() {
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            if (i == commandList.size() - 1) {
                stringbuilder.append(0);
                stringbuilder.append(". ");
                stringbuilder.append(commandList.get(i).getCommandDescription());
                stringbuilder.append("\n");
            } else {
                stringbuilder.append(i + 1);
                stringbuilder.append(". ");
                stringbuilder.append(commandList.get(i).getCommandDescription());
                stringbuilder.append("\n");
            }
        }
        System.out.println(stringbuilder);
    }

    public void execute(int input) {
        if (input == 0) input = commandList.size();
        Command command = commandList.get(input - 1);
        command.execute();
    }

    public int size() {
        return commandList.size();
    }
}
