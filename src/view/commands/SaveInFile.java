package view.commands;

import view.ConsoleUI;

public class SaveInFile extends Command{

    public SaveInFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сохранить дерево в файл";
    }

    public void execute(){
        consoleUI.saveInFile();
    }
}