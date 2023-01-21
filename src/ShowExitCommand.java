public class ShowExitCommand<T extends LiveBeing<T>> implements ICommand {
    private FamilyTreeView<T> familyTreeView;

    public ShowExitCommand(FamilyTreeView<T> familyTreeView) {
        this.familyTreeView = familyTreeView;
    }

    @Override
    public void execute() {
        this.familyTreeView.quite();
    }

    @Override
    public String discription() {
        return "Выход.";
    }

}