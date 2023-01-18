public class Command_SortByAge implements Command {

    UI ui;

    public Command_SortByAge(UI ui) {
        this.ui = ui;
    }

    @Override
    public void execute() {
        System.out.println(ui.getPresenter().sortByAge("age"));
    }

    @Override
    public String description() {
        return "сортировать дерево по возрасту";
    }

}
