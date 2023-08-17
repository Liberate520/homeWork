package family_tree.view.commands.show;

import family_tree.view.ConsoleUI;
import family_tree.view.commands.Command;

public class ShowSibling extends Command{
    public ShowSibling(ConsoleUI consoleUi) {
        super(consoleUi, "Показать братьев и сестер.");
    }

    @Override
    public void execute() {
        super.consoleUi.showSibling();
    }
}
