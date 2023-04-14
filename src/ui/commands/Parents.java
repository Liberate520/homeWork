package ui.commands;

import ui.Console;

import java.io.IOException;

public class Parents extends Command {
    public Parents(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Показать родителей";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {{
            getConsole().read();
        }
    }
}
