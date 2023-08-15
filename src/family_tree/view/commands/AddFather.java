package family_tree.view.commands;

import family_tree.view.view.ConsoleUI;

public class AddFather extends Command{
    public AddFather(ConsoleUI console) {
        super("Добавить отца", console);
    }

    public void execute() {
        getConsole().addFather();
    }
}
