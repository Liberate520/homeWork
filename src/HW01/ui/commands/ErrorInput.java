package HW01.ui.commands;

import HW01.ui.Console;

public class ErrorInput extends Command {
    public ErrorInput(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "неверный ввод";
    }

    @Override
    public void execute() {
        getConsole().errorInput();
    }
}
