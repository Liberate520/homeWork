package ui.console.commands;

import ui.View;

public class GetFamily implements Command{
    private View view;

    public GetFamily(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Показать всю семью";
    }

    @Override
    public void execute() {
        view.getFamily();
    }
}
