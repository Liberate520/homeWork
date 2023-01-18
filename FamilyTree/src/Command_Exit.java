public class Command_Exit implements Command {

    UI ui;

    public Command_Exit(UI ui) {
        this.ui = ui;
    }

    @Override
    public void execute() {
        ui.getPresenter().saveMyFamilyTree();
        System.exit(0);
    }

    @Override
    public String description() {
        return "сохранить и выйти";
    }

}
