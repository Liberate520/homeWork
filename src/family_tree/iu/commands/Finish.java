package family_tree.iu.commands;

import family_tree.iu.ConsoleUI;

public class Finish extends Command{

    public Finish(ConsoleUI consoleUI){
        super("Exit",consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().finish();
    }
}
