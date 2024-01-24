package ru.gb.view;

import ru.gb.view.commands.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commands;

    public MainMenu(ConsoleUI console) {
        commands = new ArrayList<>();

        commands.add(new AddTreeItem(console));
        commands.add(new AddDad(console));
        commands.add(new AddMom(console));
        commands.add(new AddChild(console));
        commands.add(new SetDeathDate(console));
        commands.add(new CreateNewFamilyTree(console));
        commands.add(new GetAllTreesInfo(console));
        commands.add(new GetInfoByName(console));
        commands.add(new SortByAge(console));
        commands.add(new SortByName(console));
        commands.add(new SaveTrees(console));
        commands.add(new LoadTrees(console));
        commands.add(new Finish(console));
    }

    public String menu() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).getDescription());
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

    public int size() {
        return commands.size();
    }

    public void execute(int choice) throws IOException, ClassNotFoundException {
        Command command = commands.get(choice - 1);
        command.execute();
    }
}
