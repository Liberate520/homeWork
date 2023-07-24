package family_tree.view.commands;

import family_tree.view.ConsoleUi;

public class Finish extends Command{
    public Finish(ConsoleUi consoleUi){
        super(consoleUi, ": Завершить работу");


    }
    public void execute(){
        consoleUi.finish();
    }
}
