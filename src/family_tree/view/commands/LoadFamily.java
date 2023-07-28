package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class LoadFamily extends Command{
    public LoadFamily(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Загрузить семью из файла";
    }

    @Override
    public void execute() {
        consoleUI.loadFamily();
    }
}
