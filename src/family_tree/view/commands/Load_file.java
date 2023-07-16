package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class Load_file extends Command{

    public Load_file(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Загрузить семейное древо из файла;";
    }
    public void execute() {
        consoleUI.load_file();
    }
}
