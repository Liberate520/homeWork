package family_tree.view.commands;

import family_tree.view.Console;

public class SortByDateOfBirth extends Command {
    public SortByDateOfBirth(Console console) {
        super(console);
        description = "Получить список членов семейного древа, отсортированный по дате рождения.";
    }

    public void execute(){
        console.sortByDateOfBirth();
    }
}
