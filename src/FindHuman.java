public class FindHuman extends Command {
    public FindHuman(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Поиск человека";
    }

    @Override
    public void execute() {
        super.getConsole().showEntry();
    }
}