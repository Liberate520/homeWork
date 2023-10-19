package homeWork3.UI;

public class SaveFamily extends Command {
    public SaveFamily(Console console) {
        super(console);
    }

    @Override
    public String details() {
        return "Сохранить семью. ";
    }

    @Override
    public void execute() {
        getConsole().saveFamily();
    }
}
