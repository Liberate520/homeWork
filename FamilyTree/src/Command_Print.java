public class Command_Print implements Command {

    UI ui;

    public Command_Print(UI ui) {
        this.ui = ui;
    }

    @Override
    public void execute() {
        UI.getPresenter().printMyFamilyTree();
    }

    @Override
    public String description() {
        return "показать дерево полностью";
    }
}
