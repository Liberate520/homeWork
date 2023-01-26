package Seminars_OOP.HW_7.src.View;

public class CommandSortByAge implements Options {

    View view;

    public CommandSortByAge(View view) {
        this.view = view;
    }


    @Override
    public void execute() {
        view.sortByAge();

    }

    @Override
    public String description() {
        return "Отсортируем по возрасту.";
    }
}


