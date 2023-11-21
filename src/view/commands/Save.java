package view.commands;

import view.ConsoleUI;

public class Save extends Commands{
    public Save(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сохранить данные";
    }

    public void execute(){
        consoleUI.save();
    }
}
