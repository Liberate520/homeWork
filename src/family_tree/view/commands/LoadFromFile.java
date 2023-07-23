package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class LoadFromFile extends Command {
    public LoadFromFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Выполнить чтение содержимого дерева из файла";
    }
    public void execute(){
        consoleUI.loadFromFile();
    }
}
