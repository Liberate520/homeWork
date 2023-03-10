
public class ShowEntry extends Command {
    public ShowEntry(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Show human info";
    }

    @Override
    public void execute() {
        super.getConsole().showEntry();
    }
}