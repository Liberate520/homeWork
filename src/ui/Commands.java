package ui;

public abstract class Commands implements Ioptions {
    protected Console console;
    public Commands(Console console){
        this.console = console;
    }

    public Console getConsole() {
        return console;
    }
}
