package UI.Commands.GetHumanInfo;

import UI.Commands.Command;
import UI.Console;

public class GetHuman extends Command {
    public GetHuman(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Посмотреть общие сведения о человеке";
    }

    @Override
    public void execute() {
        getConsole().getHuman();
    }

}
