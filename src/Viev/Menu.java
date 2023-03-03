package Viev;

import java.util.ArrayList;
import java.util.List;
import commands.AddHuman;
import commands.Exit;
import commands.FamilyPrint;
import commands.HumanSearch;
import commands.Option;

public class Menu
{
    private List<Option> commands;
    private Console console;

    public Menu(Console console)
    {
        this.console = console;
        commands = new ArrayList<>();
        commands.add(new AddHuman(console));
        commands.add(new FamilyPrint(console));
        commands.add(new HumanSearch(console));
        commands.add(new Exit(console));
    }

    void execute(int num)
    {
        Option option = commands.get(num-1);
        option.execute();
    }

    public String printMenu()
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n\t- =  Μενώ  = -\n");
        for (int i = 0; i < commands.size(); i++)
        {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).description());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    void print()
    {
        System.out.println(console);
    }
}