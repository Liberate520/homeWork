package ui.console.commands;

import ui.View;

import java.io.IOException;

public class GetRelatives implements Command{
    private View view;
    public GetRelatives(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Показать родственников члена семьи";
    }

    @Override
    public void execute() {
        view.getRelatives();
    }
}
