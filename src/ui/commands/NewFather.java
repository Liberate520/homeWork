package ui.commands;

import ui.Console;
import java.io.IOException;

public class NewFather extends Command{
    public NewFather(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Добавить отца";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {{
            getConsole().read();
        }
    }
}
