package family_tree.view.commands;

import family_tree.view.Console;

public class SortByAge extends Command{
    public SortByAge(Console console) {
        super(console);
        description = "Получить список членов семейного древа, отсортированный по их возрасту.";
    }
    public void execute(){
        console.sortByAge();
    }
}
