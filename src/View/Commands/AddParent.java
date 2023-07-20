package View.Commands;

import View.ViewConsole;

public class AddParent extends Command{
    public AddParent(ViewConsole viewConsole) {
        super(viewConsole);
    }

    @Override
    public String getDescription() {
        return "Добавить родителя";
    }

    @Override
    public void execute() {
        getViewConsole().addParent();

    }
}