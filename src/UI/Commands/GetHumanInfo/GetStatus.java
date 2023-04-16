package UI.Commands.GetHumanInfo;

import UI.Commands.Command;
import UI.Console;

public class GetStatus extends Command {
    public GetStatus(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Посмотреть статус";
    }

    @Override
    public void execute() {
        getConsole().getStatus();
    }

}
