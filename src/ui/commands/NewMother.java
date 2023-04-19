package UI.commands;

import UI.Console;
import java.io.IOException;

public class NewMother extends Command{
    public NewMother(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Добавить мать";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {{
            getConsole().newMother();
        }
    }
}
