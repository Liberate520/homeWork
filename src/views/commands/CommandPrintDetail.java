package views.commands;

import views.ConsoleUI;

public class CommandPrintDetail implements Command {
    private ConsoleUI ui;

    public CommandPrintDetail(ConsoleUI ui) {
        this.ui = ui;
    }

    @Override
    public String getDescription() {
        return "Print detail";
    }

    @Override
    public void execute() {
        ui.printDetail();
    }

}
