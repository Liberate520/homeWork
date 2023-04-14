package ui.commands;

import ui.Console;
import java.io.IOException;

public class DateOfBirth extends Command{
    public DateOfBirth(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Дата рождения";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {{
            getConsole().read();
        }
    }
}
