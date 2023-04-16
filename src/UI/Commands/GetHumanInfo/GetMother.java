package UI.Commands.GetHumanInfo;

import UI.Commands.Command;
import UI.Console;

public class GetMother extends Command {
    public GetMother(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Посмотреть  мать";
    }

    @Override
    public void execute() {
        getConsole().getMother();
    }

}
