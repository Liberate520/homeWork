package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class Marriage extends Command{

    public Marriage(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Зарегистрировать брак;";
    }
    public void execute() {
        consoleUI.marriage();
    }
}
