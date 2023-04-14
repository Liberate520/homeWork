package ui.commands;

import ui.Console;
import java.io.IOException;

public class DateOfDeath extends Command{
    public DateOfDeath(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Дата смерти";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {{
            getConsole().read();
        }
    }
}
