package view.commands;

import view.View;

public class addNewPersonAs implements Command{
    private View view;

    public addNewPersonAs(View view) {
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
