package view.commands;

import view.ConsoleUI;

public class Download extends Commands{
    public Download(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Загрузить данные";
    }

    public void execute(){
        consoleUI.download();
    }
}