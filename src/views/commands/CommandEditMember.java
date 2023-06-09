package views.commands;

import views.ConsoleUI;
/** команда редактирования члена семьи */
public class CommandEditMember implements Command {

    private ConsoleUI ui;
    
    public CommandEditMember(ConsoleUI ui) {
        this.ui = ui;
    }

    @Override
    public String getDescription() {
        return "Edit";
    }

    @Override
    public void execute() {
        ui.editMember();
    }  
}
