package view.commands;

import view.View;


public class PrintSortByFirstName implements Command{
    private View view;

    public PrintSortByFirstName(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Вывод персон, отсортированных по имени";
    }

    @Override
    public void execute() {
        view.printSortByFirstName();
    }
}
