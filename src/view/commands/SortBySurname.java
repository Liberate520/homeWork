package view.commands;

import view.View;

public class SortBySurname extends Command{
    public SortBySurname(View view) {
        super(view, "Сортировка по фамилии");
    }

    @Override
    public void execute() {
        getView().sortBySurname();
    }
}
