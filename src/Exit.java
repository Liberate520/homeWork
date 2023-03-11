
public class Exit extends Command {

    public Exit(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Finish work";
    }

    @Override
    public void execute() {
        getConsole().finish();
    }
}