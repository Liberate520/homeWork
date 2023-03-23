package UI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import commands.*;

public class Menu {
    private List<Option> commands;
    private Console console;

    public Menu(Console console) {
        this.console = console;
        commands = new ArrayList<>();
        commands.add(new AddNewHuman(console));
        commands.add(new FindHuman(console));
        commands.add(new PrintTree(console));
        commands.add(new Save(console));
        commands.add(new Load(console));
        commands.add(new Exit(console));
    }

    void execute(int num) throws IOException, ClassNotFoundException {
        Option option = commands.get(num - 1);
        option.execute();
    }

    public String printMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(" - ");
            stringBuilder.append(commands.get(i).description());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public List<Option> getCommands() {
        return commands;
    }
}