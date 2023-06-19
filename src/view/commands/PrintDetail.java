package view.commands;

import view.ConsoleUI;

public class PrintDetail implements Command{
    private final ConsoleUI ui;

    public PrintDetail(ConsoleUI ui) {
        this.ui = ui;
    }

    @Override
    public String getDescription() {
        return "Напечатать детально";
    }

    @Override
    public void execute() {
        ui.printDetail();
    }
}
