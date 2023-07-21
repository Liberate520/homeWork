package UI.Commands.GetHumanInfo;

import UI.Commands.Command;
import UI.Console;

public class GetFather extends Command {
    public GetFather(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Посмотреть  отца";
    }

    @Override
    public void execute() {
        getConsole().getFather();
    }

}
