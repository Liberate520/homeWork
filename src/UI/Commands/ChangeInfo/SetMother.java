package UI.Commands.ChangeInfo;

import UI.Commands.Command;
import UI.Console;

public class SetMother extends Command {
    public SetMother(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Изменить сведения о матери";
    }

    @Override
    public void execute() {
        getConsole().setMother();
    }

}
