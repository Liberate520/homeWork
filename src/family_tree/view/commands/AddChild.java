package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class AddChild extends Command{
    public AddChild(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить связь 'родитель-потомок'";
    }

    public void execute(){
        consoleUI.addChild();
    }
}
