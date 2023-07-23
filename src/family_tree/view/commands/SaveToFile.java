package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class SaveToFile extends Command{
    public SaveToFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Выполнить запись содержимого дерева в файл";
    }
    public void execute(){
        consoleUI.saveToFile();
    }
}
