package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class AddHuman extends Command {


    public AddHuman(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "добавить новую запись в список";
    }
    @Override
    public void execute() { getConsoleUI().addHuman(); }


}
