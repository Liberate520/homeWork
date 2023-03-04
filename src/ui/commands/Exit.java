package ui.commands;
import ui.Console;

public class Exit extends Command {
    public Exit(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Выход";
    }

    @Override
    public void execute() {
        getConsole().finish();
    }
}