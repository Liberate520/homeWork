package view.commands;

import view.Console;

public class SortById extends Command {
    public SortById(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Сортировка по ID ";
    }

    @Override
    public void execute() {
        getConsole().sortById();
    }
}
