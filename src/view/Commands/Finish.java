package view.Commands;

import view.ConsoleUI;

public class Finish extends Commands{
    Finish(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Выход из программы.";
    }

    @Override
    public void execute() {
        this.consoleUI.finish();
    }
}
