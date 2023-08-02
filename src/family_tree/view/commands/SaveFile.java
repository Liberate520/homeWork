package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class SaveFile extends Command{
    public SaveFile(ConsoleUI consoleUI) {
        super("Сохранить дерево",consoleUI);
    }
    public void execute(){
        getConsoleUI().saveFile();
    }
}
