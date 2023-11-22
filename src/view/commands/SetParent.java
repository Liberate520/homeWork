package view.commands;

import view.ConsoleUI;

public class SetParent extends Commands {

    public SetParent(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить родителя";
    }

    public void execute(){
        consoleUI.setParent();
    }
}
