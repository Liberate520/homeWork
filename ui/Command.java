package homeWork3.ui;

public abstract class Command implements Options {
    private Console console;

    public Command(Console console) {
        this.console = console;
    }

    public Console getConsole() {
        return console;
    }

}
