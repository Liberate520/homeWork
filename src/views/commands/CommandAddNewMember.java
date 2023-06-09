package views.commands;

import views.ConsoleUI;

/** команда добавления нового члена семьи */
public class CommandAddNewMember implements Command {
        private ConsoleUI ui;
    public CommandAddNewMember(ConsoleUI ui){
        this.ui = ui;
    }
    
    @Override
    public String getDescription() {
        return "Add new member";
    }

    @Override
    public void execute() {
        ui.addNewMember();
    }
}
