package view.commands;

import view.View;

public class SortByAge extends Command{
    public SortByAge(View view) {
        super(view, "Сортировка по возрасту");
    }

    @Override
    public void execute() {
        getView().sortByAge();
    }
}
