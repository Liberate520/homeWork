package view;

import view.commands.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;

    public MainMenu(ConsoleUI consoleUI){
        commandList = new ArrayList<>();
        commandList.add(new AddCreature(consoleUI));
        commandList.add(new GetCreatureListInfo(consoleUI));
        commandList.add(new SortByName(consoleUI));
        commandList.add(new SortByAge(consoleUI));
        commandList.add(new Finish(consoleUI));
    }
    public  String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Меню:\n");
        for (int i = 0; i < commandList.size(); i++){
            Command command = commandList.get(i);
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(command.getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void choice(int index) {
        Command command = commandList.get(index - 1);
        command.execute();
    }

    public int size(){
        return commandList.size();
    }
}
