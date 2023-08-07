package View.commands;
import View.*;
public class Saver extends Command {

    public Saver(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сохранить в файл";
    }

    @Override
    public void execute() {
        consoleUI.save();
    }
}
