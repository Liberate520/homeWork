package view.commands;

import presenter.Presenter;

public class PersonAdder implements Command{
    String description = "Add person";

    public void start(Presenter presenter){
        presenter.createPerson();
    }

    @Override
    public String getDescription() {
        return description;
    }
}
