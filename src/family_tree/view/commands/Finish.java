package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class Finish extends Command {


    public Finish(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "закончить работу со списком";
    }
    @Override
    public void execute(){
        consoleUI.finish();
    }
}