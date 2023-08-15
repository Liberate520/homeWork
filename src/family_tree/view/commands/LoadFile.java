package family_tree.view.commands;

import family_tree.view.view.ConsoleUI;

public class LoadFile extends Command{
    public LoadFile(ConsoleUI console) {
        super("Загрузить файл", console);
    }

    @Override
    public void execute() {
        getConsole().loadFile();
    }
}
