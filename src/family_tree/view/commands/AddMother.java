package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class AddMother extends Command{
    public AddMother(ConsoleUI console) {
        super("Добавить мать", console);
    }

    public void execute() {
        getConsole().addMother();
    }
}
