package family_tree.iu.commands;

import family_tree.iu.ConsoleUI;

public class ErrorInput extends Command{

    public ErrorInput(ConsoleUI consoleUI){
        super("Wrong data. Repeat, please",consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().finish();
    }
}
