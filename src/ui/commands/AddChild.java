package ui.commands;

import ui.ConsoleUI;

public class AddChild extends Command{
    public AddChild(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить одному члену семьи в качестве ребенка другого члена семьи";
    }

    @Override
    public boolean execute() {
        return getConsoleUI().addChild();
    }
}
