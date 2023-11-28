package view;

import java.util.ArrayList;
import java.util.List;

import view.commands.Command;
import view.commands.SortByAge;
import view.commands.SortByChildren;
import view.commands.SortByGender;
import view.commands.SortByName;

public class Sortmenu {
    private List<Command> commandList;

    public Sortmenu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new SortByName(consoleUI));
        commandList.add(new SortByAge(consoleUI));
        commandList.add(new SortByGender(consoleUI));
        commandList.add(new SortByChildren(consoleUI));
    }

    public String sortmenu(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append("\t");
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice){
        Command command = commandList.get(choice-1);
        command.execute();
    }

    public int getSize(){
        return commandList.size();
    }
}
