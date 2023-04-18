package UI.commands;

import UI.Console;
import java.io.IOException;

public class NewPerson extends Command {
    public NewPerson(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Новый человек";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {{
            getConsole().newPerson();
        }
    }
}
