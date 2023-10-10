package ru.gb.family_tree.View;

import ru.gb.family_tree.View.Command.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;

    public MainMenu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new InfoCom(consoleUI));
        commandList.add(new SortByName(consoleUI));
        commandList.add(new SortByAge(consoleUI));
        commandList.add(new SortByDateOfBirth(consoleUI));
        commandList.add(new SortByGender(consoleUI));
        commandList.add(new Finish(consoleUI));

    }

    public String menu(){
        StringBuilder sb = new StringBuilder();
        sb.append("Меню:\n");
        for (int i = 0; i < commandList.size(); i++) {
            Command command = commandList.get(i);
            sb.append(i+1);
            sb.append(". ");
            sb.append(command.getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }
    public void choice(int index){
        Command command = commandList.get(index-1);
        command.execute();
    }
    public int size(){
        return commandList.size();
    }
}
