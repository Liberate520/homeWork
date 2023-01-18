public class Command_SortByName implements Command {

    UI ui;

    public Command_SortByName(UI ui) {
        this.ui = ui;
    }

    @Override
    public void execute() {
        System.out.println(ui.getPresenter().sortByName("name"));
    }

    @Override
    public String description() {
        return "сортировать дерево по имени";
    }

}
