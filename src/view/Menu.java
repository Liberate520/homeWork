package view;

import view.commands.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Command> commandList;

    public Menu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new ReadFile(consoleUI));
        commandList.add(new GetInfo(consoleUI));
        commandList.add(new AddPerson(consoleUI));
        commandList.add(new SortByName(consoleUI));
        commandList.add(new SortByAge(consoleUI));
        commandList.add(new AddSpouse(consoleUI));
        commandList.add(new AddChildren(consoleUI));
        commandList.add(new SaveFile(consoleUI));
        commandList.add(new Finish(consoleUI));
    }
    public String menu(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            sb.append(i+1);
            sb.append(". ");
            sb.append(commandList.get(i).getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void execute(int choice){
        Command command = commandList.get(choice-1);
        try {
            command.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public int getSize(){
        return commandList.size();
    }
}
