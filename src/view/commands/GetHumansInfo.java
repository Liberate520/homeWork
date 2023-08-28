package src.view.commands;
import src.view.ConsoleUI;

public class GetHumansInfo  extends Command {

    public GetHumansInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывести людей ...";
    }
    @Override
//    public void execute(){getConsole().addHumanNew();}
    public void execute(){consoleUI.getHumansInfo();}
}
