package family_tree.ui.commands;

import family_tree.ui.Console;

public class AddHuman extends Command {
    public AddHuman(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Добавление человека в семью. ";
    }

    @Override
    public void execute() {
        getConsole().addHumanNew();
    }
}
