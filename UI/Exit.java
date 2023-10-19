package homeWork3.UI;

public class Exit extends Command {
    public Exit(Console console) {
        super(console);
    }

    @Override
    public String details() {
        return "Выйти.";
    }

    @Override
    public void execute() {
        getConsole().end();
    }
}