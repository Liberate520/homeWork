package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class ReadFile extends Command{
    public ReadFile (ConsoleUI consoleUI) {
        super("Открыть дерево",consoleUI);
    }
    public void execute(){
        getConsoleUI().readFile();
    }
}
