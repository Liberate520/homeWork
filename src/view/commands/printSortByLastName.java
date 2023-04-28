package view.commands;

import view.View;


public class printSortByLastName implements Command{
    private View view;

    public printSortByLastName(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Вывод персон, отсортированных по фамилии";
    }

    @Override
    public void execute() {
        view.printSortByLastName();
    }
}
