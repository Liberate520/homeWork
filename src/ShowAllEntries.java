
public class ShowAllEntries  extends Command {
    public ShowAllEntries(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Show all relatives info";
    }

    @Override
    public void execute() {
        super.getConsole().showAllEntries();
    }
}
