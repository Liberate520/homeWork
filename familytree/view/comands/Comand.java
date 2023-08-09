package familytree.view.comands;
import familytree.view.Console;

public abstract class Comand {
    protected String description;
    Console console;

    public Comand(Console console) {
        this.console = console;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute();
}
