package homeWork3.ui;

public class SortByName extends Command {
    public SortByName(Console console) {
        super(console);
    }

    @Override
    public String details() {
        return "Сортировка семейного дерева по имени. ";
    }

    @Override
    public void execute() {
        getConsole().sortFamilyByName();
    }
}
