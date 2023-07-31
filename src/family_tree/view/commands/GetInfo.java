package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class GetInfo extends Command {
    public GetInfo(ConsoleUI consoleUI) {
        super(consoleUI, "Показать дерево");
    }

    public void execute() {
        consoleUI.getInfo();
    }
}


