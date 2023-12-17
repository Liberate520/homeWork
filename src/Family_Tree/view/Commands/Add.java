package Family_Tree.view.Commands;

import Family_Tree.view.ConsoleUI;
import Family_Tree.view.View;

public class Add extends Command{

    public Add(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить человека";
    }

    @Override
    public void execute() {
        consoleUI.add();
    }


}