package View.Commands;

import View.View;

public class SortByName extends Command {

    public SortByName(View view) {
        super(view, "Сортировка по имени");
    }


    @Override
    public void execute() {
        getView().sortByName();
    }
}
