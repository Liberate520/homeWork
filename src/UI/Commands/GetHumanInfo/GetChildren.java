package UI.Commands.GetHumanInfo;

import UI.Commands.Command;
import UI.Console;

public class GetChildren extends Command {
    public GetChildren(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Посмотреть   детей";
    }

    @Override
    public void execute() {
        getConsole().getChildren();
    }

}
