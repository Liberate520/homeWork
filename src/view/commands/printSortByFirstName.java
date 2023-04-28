package view.commands;

import view.View;


public class printSortByFirstName implements Command{
    private View view;

    public printSortByFirstName(View view) {
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
