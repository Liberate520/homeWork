package view.commands;

import view.View;


public class PrintSortByAge implements Command{
    private View view;

    public PrintSortByAge(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Вывод персон, отсортированных по возрасту";
    }

    @Override
    public void execute() {
        view.printSortByAge();
    }
}
