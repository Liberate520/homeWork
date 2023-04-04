package Seminar6.src.ui.commands;

import Seminar6.src.ui.ConsoleUi;

public class Finish extends Commands {
    boolean signal = false;

    public Finish(ConsoleUi cU) {
        super(cU);
    }

    public String toString() {
        return "Закончить работу";
    }

    @Override
    public void execute() {
        consoleUi.finish();

    }
}
