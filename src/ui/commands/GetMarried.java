package ui.commands;

import ui.View;

public class GetMarried implements Command{
    private View view;

    public GetMarried(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Поженить";
    }

    @Override
    public void execute() {
        view.getMarried();
    }
}
