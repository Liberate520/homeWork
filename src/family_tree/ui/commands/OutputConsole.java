package family_tree.ui.commands;

import family_tree.ui.ConsoleView;

public class OutputConsole extends Command {
    String description;
    ConsoleView consoleView;

    public OutputConsole(ConsoleView consoleView) {
        super(consoleView);
        description = "Вывести в консоль";
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public void execute(String text) {
        consoleView.getInfo();
    }
}
