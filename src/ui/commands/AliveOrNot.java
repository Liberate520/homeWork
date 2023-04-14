package ui.commands;

import ui.Console;
import java.io.IOException;


public class AliveOrNot extends Command {
    public AliveOrNot(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Жив или нет";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {{
            getConsole().read();
        }
    }
}
