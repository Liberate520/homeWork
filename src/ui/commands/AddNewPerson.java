package ui.commands;

import presenter.Presenter;

public class AddNewPerson implements Option{

    private Presenter presenter;

    public AddNewPerson(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public String description() {
        return "Добавить нового человека";
    }

    @Override
    public String execute() {
        
        return presenter.addNewPerson();
    }
    
}
