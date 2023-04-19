package UI.commands;

import UI.Console;
import java.io.IOException;

public class NewChild extends Command{
    public NewChild(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Добавить ребёнка";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {{
            getConsole().newChild();
        }
    }
}