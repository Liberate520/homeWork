package HomeWork5.ui;

import java.util.ArrayList;
import java.util.List;
import HomeWork5.ui.commands.AddHuman;
import HomeWork5.ui.commands.Exit;
import HomeWork5.ui.commands.FamilyPrint;
import HomeWork5.ui.commands.HumanSearch;
import HomeWork5.ui.commands.Option;

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
        stringBuilder.append("\n\t- =  Меню  = -\n");
        for (int i = 0; i < commands.size(); i++) 
        {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).description());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    void print() // ПОТОМ УДАЛИТЬ !!
    {
        System.out.println(console);
    }
}

