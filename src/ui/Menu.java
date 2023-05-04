package ui;

import ui.commands.*;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Command> commandList;

    public Menu(Console console) {
        commandList = new ArrayList<>();
        commandList.add(new AddHuman(console));
        commandList.add(new ShowAllRelatives(console));
        commandList.add(new FindHumanByName(console));
        commandList.add(new ShowKids(console));
        commandList.add(new FindSiblings(console));
        commandList.add(new Finish(console));


    }

    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int numCommand) {
        commandList.get(numCommand - 1).execute();
    }
}
