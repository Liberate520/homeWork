package ui.commands;
import ui.Console;

public class SortingTrees extends Command {

    public SortingTrees(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Сортировка списка";
    }

    @Override
    public void execute() {
        getConsole().sortTree();
    }
}
