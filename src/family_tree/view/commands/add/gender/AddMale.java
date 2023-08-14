package family_tree.view.commands.add.gender;

import family_tree.view.ConsoleUI;
import family_tree.view.commands.Command;

public class AddMale extends Command{
       public AddMale(ConsoleUI consoleUi) {
        super(consoleUi, "Муж.");
    }

    @Override
    public void execute() {
        super.consoleUi.addHuman("MALE");
    }
}
