package UI.Commands.GetFamilyTree;

import UI.Commands.Command;
import UI.Console;

public class SortByID extends Command {
    public SortByID(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Сортировать по ID";
    }

    @Override
    public void execute() {
        getConsole().printByID();
    }

}
