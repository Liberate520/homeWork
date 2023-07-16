package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class Add_human extends Command{

    public Add_human(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Добавить нового члена;";
    }
    public void execute() {
        consoleUI.add_human();
    }
}
