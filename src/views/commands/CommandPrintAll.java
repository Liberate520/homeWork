package views.commands;

import views.ConsoleUI;
/** команда вывода всех членов семьи */
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
