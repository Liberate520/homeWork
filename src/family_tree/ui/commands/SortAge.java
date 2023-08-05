package family_tree.ui.commands;

import family_tree.ui.Console;

public class SortAge extends Command {
    public SortAge(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Сортировка семьи по возрасту. ";
    }

    @Override
    public void execute() {
        getConsole().sortFamilyAge();

    }
}