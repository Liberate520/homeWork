package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class SaveFamily extends Command{
    public SaveFamily(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Сохранить семью в файл";
    }
    @Override
    public void execute() {
        consoleUI.saveFamily();
    }
}
