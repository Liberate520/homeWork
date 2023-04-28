package view.commands;

import view.View;

public class AddNewPersonAs implements Command{
    private View view;

    public AddNewPersonAs(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Добавить нового родного";
    }

    @Override
    public void execute() {
        view.addNewPersonAs();
    }
}
