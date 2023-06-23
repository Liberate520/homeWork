package ui.commands;
import ui.Console;

public class LoadFile extends Command {

    public LoadFile(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Распечатать дерево из файла";
    }

    @Override
    public void execute() { getConsole().loadFile(); }
}
