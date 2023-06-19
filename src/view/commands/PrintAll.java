package view.commands;

import view.ConsoleUI;

public class PrintAll implements Command{
    private final ConsoleUI ui;
    public PrintAll(ConsoleUI ui){
        this.ui = ui;
    }

    @Override
    public String getDescription() {
        return "Напечатать все дерево";
    }

    @Override
    public void execute() {
        ui.printAll();
    }
}
