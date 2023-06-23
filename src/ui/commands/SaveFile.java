package ui.commands;
import ui.Console;

public class SaveFile extends Command {

    public SaveFile(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Сохранить дерево в файл";
    }

    @Override
    public void execute() { getConsole().saveFile(); }

}
