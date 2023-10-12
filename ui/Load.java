package homeWork3.ui;

public class Load extends Command {
    public Load(Console console) {
        super(console);
    }

    @Override
    public String details() {
        return "Загрузить семью. ";
    }

    @Override
    public void execute() {
        getConsole().loadFamily();
    }
}
