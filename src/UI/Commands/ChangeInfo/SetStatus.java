package UI.Commands.ChangeInfo;

import UI.Commands.Command;
import UI.Console;

public class SetStatus extends Command {
    public SetStatus(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Изменить статус";
    }

    @Override
    public void execute() {
        getConsole().setStatus();
    }

}
