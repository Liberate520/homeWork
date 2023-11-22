package view.Commands;

import view.ConsoleUI;

public class AddHuman extends Commands{
    AddHuman(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить человека";
    }

    @Override
    public void execute() {
        this.consoleUI.addHuman();
    }
}
