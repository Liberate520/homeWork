package ui.commands;

import ui.Console;

import java.io.IOException;

public class Read extends Command{
    public Read(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Загрузить семейное древо";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {{
            getConsole().read();
        }
    }
}
