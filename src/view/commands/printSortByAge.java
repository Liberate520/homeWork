package view.commands;

import view.View;


public class printSortByAge implements Command{
    private View view;

    public printSortByAge(View view) {
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
