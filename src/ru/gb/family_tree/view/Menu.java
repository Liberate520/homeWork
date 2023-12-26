package ru.gb.family_tree.view;

import ru.gb.family_tree.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Command> commandList;

    public Menu(Console console) {
        commandList = new ArrayList<>();
        commandList.add(new GetHumanList(console));
        commandList.add(new Finish(console));
        commandList.add(new GetByName(console));
        commandList.add(new GetHumanList(console));
        commandList.add(new Remove(console));
        commandList.add(new SortByAge(console));
        commandList.add(new SortByName(console));
    }

    public String menu() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            sb.append(i + 1);
            sb.append(". ");
            sb.append(commandList.get(i).getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void execute(int choice) {
        Command command = commandList.get(choice - 1);
        command.execute();
    }

    public int getSize() {
        return commandList.size();
    }
}