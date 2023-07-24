package family_tree.view.commands;

import family_tree.view.ConsoleUi;

public class AddHuman extends Command {

    public AddHuman(ConsoleUi consoleUi){
        super(consoleUi, ": Добавить члена семьи");


    }
    public void execute(){
        consoleUi.addHuman();
    }
}
