package src.view.commands;
import src.view.ConsoleUI;
public class LoadHumansFromFile  extends Command {
    public LoadHumansFromFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Загрузить из файла ...";
    }
    @Override
    public void execute(){consoleUI.LoadHumansFromFile();}
}
