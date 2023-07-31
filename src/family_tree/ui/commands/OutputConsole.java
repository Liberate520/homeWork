package family_tree.ui.commands;

import family_tree.ui.ConsoleView;

public class OutputConsole extends Command {

    public OutputConsole(ConsoleView consoleView) {
        super(consoleView);
        description = "Вывести в консоль";
    }

    @Override
    public void execute(String text) {
        consoleView.getInfo();
    }
}
