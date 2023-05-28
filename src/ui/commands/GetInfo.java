package ui.commands;

import ui.View;

public class GetInfo implements Command {
    private View view;

    public GetInfo(View view){
        this.view = view;
    }
    @Override
    public String getDescription() {
        return "Получить список семьи";
    }

    @Override
    public void execute() {
        view.getInfo();
    }
}
