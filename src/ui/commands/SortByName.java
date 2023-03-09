package ui.commands;

import presenter.Presenter;

public class SortByName implements Option{
    private Presenter presenter;

    public SortByName(Presenter presenter){
        this.presenter = presenter;
    }

    @Override
    public String description() {
        return "Отсортировать по имени";
    }

    @Override
    public String execute() {
        return presenter.sortByName();
    }
    
}
