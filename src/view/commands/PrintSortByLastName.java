package view.commands;

import view.View;


public class PrintSortByLastName implements Command{
    private View view;

    public PrintSortByLastName(View view) {
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
