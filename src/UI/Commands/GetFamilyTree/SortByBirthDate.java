package UI.Commands.GetFamilyTree;

import UI.Commands.Command;
import UI.Console;

public class SortByBirthDate extends Command {
    public SortByBirthDate(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Сортировать по дате рождения";
    }

    @Override
    public void execute() {
        getConsole().printByBirthDate();
    }

}
