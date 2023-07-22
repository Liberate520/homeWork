package family_tree.view.commands;

import family_tree.view.Console;

public class SortById extends Command {
    public SortById(Console console) {
        super(console);
        description = "Получить список членов семейного древа, отсортированный по ID.";
    }

    public void execute(){
        console.sortById();
    }
}
