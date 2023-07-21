package UI.Commands.ChangeInfo;

import UI.Commands.Command;
import UI.Console;

public class SetName extends Command {
    public SetName(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Изменить имя";
    }

    @Override
    public void execute() {
        getConsole().setName();
    }

}
