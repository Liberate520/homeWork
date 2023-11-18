package ru.gb.family_tree.ui;

import ru.gb.family_tree.ui.commands.*;
import java.util.ArrayList;
import java.util.List;

public class MainMenu {

    private List<Command> commandList;

    public MainMenu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new Load(consoleUI));
        commandList.add(new GetTree(consoleUI));
        commandList.add(new AddHuman(consoleUI));
        commandList.add(new AddBirthDate(consoleUI));
        commandList.add(new AddDeathDate(consoleUI));
        commandList.add(new AddSpouse(consoleUI));
        commandList.add(new AddChild(consoleUI));
        commandList.add(new GetDetailInfo(consoleUI));
        commandList.add(new SortById(consoleUI));
        commandList.add(new SortByLastname(consoleUI));
        commandList.add(new SortByAge(consoleUI));
        commandList.add(new Save(consoleUI));
        commandList.add(new Finish(consoleUI));
    }

    public String menu(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            sb.append(i+1).append(". ").append(commandList.get(i).getDescription()).append("\n");
        }
        return sb.toString();
    }

    public void execute(int choice){
        Command command = commandList.get(choice-1);
        command.execute();
    }

    public int getSize(){
        return commandList.size();
    }
}
