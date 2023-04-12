package view.Commands;

import view.Console;

public class Delete extends Command {

    public Delete(Console console) {
        super(console);
    }
    
    @Override
    public String act() {
        return "Delete note";
    }
    
    public void execute() {
        getConsole().deleteNote();
    }
}
