package view.commands;

import view.View;

public class AddNewPerson implements Command{
    private View view;

    public AddNewPerson(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Добавить новую персону";
    }

    @Override
    public void execute() {
        view.addNewPerson();
    }
}
