package family_tree.ui.commands;

import family_tree.ui.ConsoleView;

public class ChangeItemParameter extends Command {


    public ChangeItemParameter(ConsoleView consoleView) {
        super(consoleView);
        description = "Изменить данные";
    }

    @Override
    public void execute(String text) {
        consoleView.changeItemParameter();
    }
}
