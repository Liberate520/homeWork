package Seminar6.src.ui.commands;

import Seminar6.src.ui.ConsoleUi;

public class PrintAllNotes extends Commands {
    public PrintAllNotes(ConsoleUi cU) {
        super(cU);
    }

    public String toString() {
        return "Вывести все существующие записи";
    }

    @Override
    public void execute() {
        consoleUi.printAllNotes();

    }
}
