package views.commands;

import views.ConsoleUI;

public class CommandSave implements Command {

    private ConsoleUI ui;
    
    public CommandSave(ConsoleUI ui) {
        this.ui = ui;
    }

    @Override
    public String getDescription() {
        return "Save";
    }

    @Override
    public void execute() {
        ui.save();
    }
    
}
