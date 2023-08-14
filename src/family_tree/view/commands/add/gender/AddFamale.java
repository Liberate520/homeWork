package family_tree.view.commands.add.gender;

import family_tree.view.ConsoleUI;
import family_tree.view.commands.Command;

public class AddFamale extends Command{
        public AddFamale(ConsoleUI consoleUi) {
        super(consoleUi, "Жен.");
    }

    @Override
    public void execute() {
        super.consoleUi.addHuman("FAMALE");
    }
}
