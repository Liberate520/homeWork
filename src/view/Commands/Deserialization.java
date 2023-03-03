package View.Commands;

import View.Console;

public class Deserialization extends Command {

    public Deserialization(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Десериализация";
    }

    @Override
    public void execute() {
        getConsole().deserialization();
    }
    
}
