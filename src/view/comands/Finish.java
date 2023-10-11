package view.comands;

import view.ConsoleUI;
import view.comands.Comand;

public class Finish extends Comand {
    public Finish( ConsoleUI consoleUI )
    {
        super("Завершить", consoleUI );
    }
    @Override
    public void execute() {
        consoleUI.finish();
    }
}