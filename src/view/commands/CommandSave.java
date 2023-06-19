package view.commands;

import view.ConsoleUI;

public class CommandSave implements Command{
    private final ConsoleUI ui;

    public CommandSave(ConsoleUI ui) {
        this.ui = ui;
    }

    @Override
    public String getDescription() {
        return "Сохранить";
    }

    @Override
    public void execute() {
        ui.save();
    }
}
