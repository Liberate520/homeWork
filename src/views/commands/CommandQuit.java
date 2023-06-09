package views.commands;

import views.ConsoleUI;

public class CommandQuit implements Command {
    
    private ConsoleUI ui;
    public CommandQuit(ConsoleUI ui){
        this.ui = ui;
    }
    
    @Override
    public String getDescription() {
        return "Quit";
    }

    @Override
    public void execute() {
        ui.quit();
    }
    
}
