package View.Commands;

import View.View;

public class SortByAge extends Command{
    public SortByAge(View view) {
        super(view, "Сортировка по возрасту");
    }

    @Override
    public void execute() {
        getView().sortByAge();
    }
}
