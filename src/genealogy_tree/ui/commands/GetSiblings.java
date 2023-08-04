package genealogy_tree.ui.commands;

import genealogy_tree.ui.ConsoleUI;

public class GetSiblings extends Command {


    public GetSiblings(ConsoleUI consoleUI) {
        super(" Get siblings", consoleUI);
    }

    public void execute() {
        getConsoleUI().getSiblings();
    }

}