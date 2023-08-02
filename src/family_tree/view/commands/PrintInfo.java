package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class PrintInfo extends Command {
    public PrintInfo (ConsoleUI consoleUI) {
        super("Показать информацию",consoleUI);
    }
    public void execute(){
        getConsoleUI().printInfo();
    }
}

