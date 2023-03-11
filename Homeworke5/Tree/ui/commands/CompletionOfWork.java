package ui.commands;

import ui.Console;

public class CompletionOfWork extends Command {

    public CompletionOfWork(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Copletion of work."; 
    }

    @Override
    public void execute() {
        getConsole().finish();
    }

}