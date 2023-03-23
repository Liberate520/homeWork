package View.Commands;

import View.Console;

public class Serialization extends Command {

    public Serialization(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Сериализация";
    }

    @Override
    public void execute() {
        getConsole().serialization();
    }
    
}
