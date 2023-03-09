package ui.commands;

import presenter.Presenter;

public class SortByBirthdate implements Option{

    private Presenter presenter;

    public SortByBirthdate(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public String description() {
        return "Отсортировать по дате рождения";
    }

    @Override
    public String execute() {
        return presenter.sortByBirthdate();
    }
    
}
