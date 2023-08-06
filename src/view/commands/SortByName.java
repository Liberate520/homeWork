package src.view.commands;
import src.view.ConsoleUI;

public class SortByName  extends Command {
    public SortByName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сортировка по имени...";
    }
    @Override
    public void execute(){
        consoleUI.sortByName();
    }
}
