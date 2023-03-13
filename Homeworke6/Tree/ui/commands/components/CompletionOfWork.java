package ui.commands.components;

import ui.Console;
import ui.commands.Command;

public class CompletionOfWork extends Command {

    public CompletionOfWork(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Copmletion of work."; 
    }

    @Override
    public void execute() {
        getConsole().finish();
    }

}