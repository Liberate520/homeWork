package homeWork3.UI;

public class SearchHuman extends Command {
    public SearchHuman(Console console) {
        super(console);
    }

    @Override
    public String details() {
        return "Поиск человека по имени. ";
    }

    @Override
    public void execute() {
        getConsole().searchHuman();
    }
}