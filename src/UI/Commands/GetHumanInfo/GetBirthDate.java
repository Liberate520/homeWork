package UI.Commands.GetHumanInfo;

import UI.Commands.Command;
import UI.Console;

public class GetBirthDate extends Command {
    public GetBirthDate(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Посмотреть  день рождения";
    }

    @Override
    public void execute() {
        getConsole().getBirthDate();
    }

}
