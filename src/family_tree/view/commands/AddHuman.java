package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class AddHuman extends Command{
    public AddHuman(ConsoleUI console) {
        super("Добавить человека в семейное древо", console);
    }

    public void execute() {
        getConsole().addHuman();
    }
}
