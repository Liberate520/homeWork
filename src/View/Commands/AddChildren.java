package View.Commands;

import View.ViewConsole;

public class AddChildren extends Command{
    public AddChildren(ViewConsole viewConsole) {
        super(viewConsole);
    }

    @Override
    public String getDescription() {
        return "Добавить ребенка";
    }

    @Override
    public void execute() {
        getViewConsole().addChildren();

    }
}
