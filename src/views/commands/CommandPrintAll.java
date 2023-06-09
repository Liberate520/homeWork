package views.commands;

import views.ConsoleUI;

public class CommandPrintAll implements Command {

    private ConsoleUI ui;
    public CommandPrintAll(ConsoleUI ui){
        this.ui = ui;
    }
    
    @Override
    public String getDescription() {
        return "Print info";
    }

    @Override
    public void execute() {
        ui.printAll();
    }
    
}
