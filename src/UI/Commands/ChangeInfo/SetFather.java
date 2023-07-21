package UI.Commands.ChangeInfo;

import UI.Commands.Command;
import UI.Console;

public class SetFather extends Command {
    public SetFather(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Изменить сведения об отце";
    }

    @Override
    public void execute() {
        getConsole().setFather();
    }

}
