package view.command;

import view.ConsoleUI;

public class GetHumanInfo extends Command {
    public GetHumanInfo(ConsoleUI console) {
        super(console);
        description = "Просмотреть подробную информацию по Id";
    }

    public void execute(){
        console.getHumanInfo();
    }
}
