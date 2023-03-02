package ui;

import ui.commands.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Menu
{
    private List<Option> commands;
    private Console console;

    public Menu(Console console) {
        this.console = console;
        commands = new ArrayList<Option>();
        commands.add(new Exit(console));
        commands.add(new PrintTree(console));
        commands.add(new FindPerson(console));
        commands.add(new AddPerson(console));
        commands.add(new SaveTree(console));
        commands.add(new SortTreeByName(console));
        commands.add(new SortTreeByDate(console));
    }

    void execute(int num) throws IOException {
        Option option = commands.get(num-1);
        option.execute();
    }

    public String printMenu(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commands.size(); i++)
        {
            stringBuilder.append("\t");
            stringBuilder.append(i+1);
            stringBuilder.append(": ");
            stringBuilder.append(commands.get(i).description());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

}
