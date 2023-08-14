package family_tree.view.commands.add;

import family_tree.view.ConsoleUI;
import family_tree.view.commands.Command;
import family_tree.view.menu.SubMenuKinship;

public class AddKinship extends Command{

    public AddKinship(ConsoleUI consoleUi) {
        super(consoleUi, "Добавить родственные связи.");
    }

    @Override
    public void execute() {
        super.consoleUi.menu(new SubMenuKinship(consoleUi));
    }

}
