package Seminar6.src.ui.commands;

import Seminar6.src.ui.ConsoleUi;

public class ChangeNote extends Commands {
    public ChangeNote(ConsoleUi cU) {
        super(cU);
    }

    public String toString() {
        return "Изменить запись в  ежедневнике";
    }

    @Override
    public void execute() {
        consoleUi.changeNote();

    }
}
