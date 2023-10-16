package view.commands;
import view.ConsoleUI;

public class GetHumanInfo extends Command {
    public GetHumanInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Get info";
    }

    public void execute(){
        consoleUI.getHumanListInfo();
    }
}
