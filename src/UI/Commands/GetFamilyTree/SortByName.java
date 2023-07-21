package UI.Commands.GetFamilyTree;

import UI.Commands.Command;
import UI.Console;

public class SortByName extends Command {
    public SortByName(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Сортировать по имени";
    }

    @Override
    public void execute() {
        getConsole().printByName();
    }

}
