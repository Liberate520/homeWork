package family_Tree.view.commands;

import family_Tree.view.ConsoleUI;

public class AddChild extends Command{
    public AddChild(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить ребёнка";
    }

    @Override
    public void execute() {
        consoleUI.addChild();
    }
}
