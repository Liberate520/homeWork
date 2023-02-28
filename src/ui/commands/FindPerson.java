package ui.commands;

import presenter.Presenter;

public class FindPerson implements Option{
    Presenter presenter;

    public FindPerson(Presenter presenter){
        this.presenter = presenter;
    }

    @Override
    public String description() {
        return "Найти человека по имени";
    }

    @Override
    public String execute() {
        return presenter.findPerson();
    }
    
}
