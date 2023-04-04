package Seminar6.src.ui.commands;

import Seminar6.src.ui.ConsoleUi;

public class DeleteNote extends Commands {
    public DeleteNote(ConsoleUi consoleUi) {
        super(consoleUi);
    }

    public String toString() {
        return "Удалить запись в ежедневнике";
    }

    @Override
    public void execute() {
        consoleUi.delete();
    }
}
