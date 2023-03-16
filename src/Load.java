public class Load extends Command {
    public Load(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Загрузить";
    }

    @Override
    public void execute() {
        super.getConsole().load();
    }
}