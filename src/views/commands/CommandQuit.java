package views.commands;

import views.ConsoleUI;
/** команда выхода */
public class CommandQuit implements Command {
    
    private final ConsoleUI ui;
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
