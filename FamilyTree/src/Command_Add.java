public class Command_Add implements Command {

    UI ui;

    public Command_Add(UI ui) {
        this.ui = ui;
    }

    @Override
    public void execute() {
        Person person = ui.getPerson(ui.getMyFamilyTree());
        UI.getPresenter().addNewPerson(person);
    }

    @Override
    public String description() {
        return "добавить нового члена";
    }

}
