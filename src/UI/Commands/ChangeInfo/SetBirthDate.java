package UI.Commands.ChangeInfo;

import UI.Commands.Command;
import UI.Console;

public class SetBirthDate extends Command {
    public SetBirthDate(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Изменить дату рождения";
    }

    @Override
    public void execute() {
        getConsole().setBirthDate();
    }

}
