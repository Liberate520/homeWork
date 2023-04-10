public abstract class Command {
    private final ConsoleView console;
    public Command(ConsoleView console) {
        this.console = console;
    }

    public abstract String description();

    public ConsoleView getConsole() {
        return console;
    }

    public abstract void execute();
}
