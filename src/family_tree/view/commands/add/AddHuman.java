package family_tree.view.commands.add;

import family_tree.view.ConsoleUI;
import family_tree.view.commands.Command;
import family_tree.view.menu.SubMenuGender;

public class AddHuman extends Command{

    public AddHuman(ConsoleUI consoleUi) {
        super(consoleUi, "Добавить человека.");
    }

    @Override
    public void execute() {
        super.consoleUi.menu(new SubMenuGender(consoleUi));;
    }
    
}
