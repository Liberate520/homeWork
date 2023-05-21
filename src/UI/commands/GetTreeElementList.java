package UI.commands;

import UI.Console;

public class GetTreeElementList extends Command {
    public GetTreeElementList(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Вывести генеалогисеское древо";
    }

    @Override
    public void execute() {
        getConsole().getElementList();
    }
}
