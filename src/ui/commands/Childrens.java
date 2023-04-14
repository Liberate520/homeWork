package ui.commands;

import ui.Console;
import java.io.IOException;

public class Childrens extends Command {
    public Childrens(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Список детей";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {{
            getConsole().read();
        }
    }
}
