package Seminars_OOP.HW_7.src.View;

public class CommandSortByName implements Options {

    View view;

    public CommandSortByName(View view) {
        this.view = view;
    }

    @Override
    public void execute() {
        view.sortByName();


    }
    @Override
    public String description() {
        return "Отсортируем по имени.";
    }
}


