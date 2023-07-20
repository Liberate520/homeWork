package Homework.view.commands;

import Homework.view.ConsoleUI;

public class SaveInFile extends Command{
    public SaveInFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сохранить в файл";
    }

    public void execute(){
        consoleUI.saveInFile();
    }
}
