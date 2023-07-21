package UI.Commands.ChangeInfo;

import UI.Commands.Command;
import UI.Console;

public class SetSurname extends Command {
    public SetSurname(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Изменить фамилию";
    }

    @Override
    public void execute() {
        getConsole().setSurname();
    }

}
