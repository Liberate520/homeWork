package family_tree.view.commands;

import family_tree.view.view.ConsoleUI;

public class SaveFile extends Command{

    public SaveFile(ConsoleUI console) {
        super("Сохранить файл", console);
    }

    @Override
    public void execute() {
        getConsole().saveFile();
    }
}
