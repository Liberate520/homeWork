package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class Set_relatives extends Command{

    public Set_relatives(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Установить родственную связь;";
    }
    public void execute() {
        consoleUI.menu_choice("menu_relatives");
    }
}
