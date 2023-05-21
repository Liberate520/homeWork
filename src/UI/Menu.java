package UI;

import UI.commands.*;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Command> commands;
    private Console console;

    public Menu(Console console) {
        this.console = console;
        commands = new ArrayList<>();
        commands.add(new LoadFrom(console));
        commands.add(new SaveTo(console));
        commands.add(new GetTreeElementList(console));
        commands.add(new FindElement(console));
        commands.add(new AddElement(console));
        commands.add(new SetFather(console));
        commands.add(new SetMother(console));
        commands.add(new AddChildren(console));
        commands.add(new Sort(console));
        commands.add(new Exit(console));

    }

    void doit(int choice) {
        commands.get(choice - 1).execute();
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < commands.size(); i++) {
            sb.append(i + 1).append(". ").append(commands.get(i).getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }

    public int getSize() {
        return commands.size();
    }
}
