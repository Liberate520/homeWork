package family_Tree.view.commands;

import family_Tree.view.ConsoleUI;

public class Load extends Command{
    public Load(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Загрузить ранее сохраненное древо";
    }

    @Override
    public void execute() {
        consoleUI.load();
    }
}
