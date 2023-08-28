package src.view.commands;
import src.view.ConsoleUI;

public class AppendHumansFromFile  extends Command {

    public AppendHumansFromFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить из файла ...";
    }
    @Override
    public void execute() {consoleUI.AppendHumansFromFile();}
}
