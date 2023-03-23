package ui.comands;

import ui.ConsoleUI;

public class PrintAll extends Command{
    public PrintAll(ConsoleUI console) {
        super(console);
    }

    @Override
    public String description() {
        return "Показать все заметки";
    }

    public void execute() {
        getConsole().printAll();
    }
}
