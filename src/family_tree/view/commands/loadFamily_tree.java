package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class loadFamily_tree extends Command{

    public loadFamily_tree(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Загрузить семейное древо из файла;";
    }
    public void execute() {
        consoleUI.loadFamily_tree();
    }
}
