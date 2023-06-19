package view.commands;

import view.ConsoleUI;

public class EditMember implements Command{
    private final ConsoleUI ui;

    public EditMember(ConsoleUI ui) {
        this.ui = ui;
    }

    @Override
    public String getDescription() {
        return "Изменить";
    }

    @Override
    public void execute() {
        ui.editMember();
    }
}
