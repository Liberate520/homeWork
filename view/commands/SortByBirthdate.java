package view.commands;
import view.ConsoleUI;

public class SortByBirthdate extends Command {
    public SortByBirthdate(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Sort by birth date";
    }

    public void execute(){
        consoleUI.SortByBirthdate();
    }
}
