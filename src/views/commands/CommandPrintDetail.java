package views.commands;

import views.ConsoleUI;
/** команда вывода подробной информации о члене семьи */
public class CommandPrintDetail implements Command {
    private final ConsoleUI ui;

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
