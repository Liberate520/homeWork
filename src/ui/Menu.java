package ui;

import ui.commands.*;

import java.util.ArrayList;
import java.util.List;

public class Menu{

    private List<Command> commands;

    public Menu(ConsoleUI console) {
        commands = new ArrayList<>();
        commands.add(new PrintTree(console));
        commands.add(new SearchMember(console));
        commands.add(new AddMember(console));
        commands.add(new RemoveMember(console));
        commands.add(new ClearTree(console));
        commands.add(new LoadTree(console));
        commands.add(new SaveTree(console));
        commands.add(new Finish(console));
    }

    public void execute(int choice) {
        commands.get(choice - 1).execute();
    }

    public String print() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < commands.size(); i++) {
            builder.append(i + 1)
                    .append(". ")
                    .append(commands.get(i).getDescription());
        }
        return builder.toString();
    }
}
