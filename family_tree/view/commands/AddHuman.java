package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class AddHuman extends Command {

    public AddHuman(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить человека";
    }

    @Override
    public void execute() {
        consoleUI.addHuman();
    }

    public String getDescription(){
        return description;
    }
    

}
