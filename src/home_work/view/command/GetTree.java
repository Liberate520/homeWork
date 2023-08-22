package home_work.view.command;

import home_work.view.ConsoleUI;

public class GetTree extends Command{

    public GetTree(ConsoleUI consoleUI) {
        super("Вывести дерево по имени человека",consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().getTree();
    }
    
}
