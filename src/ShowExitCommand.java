public class ShowExitCommand<T extends LiveBeing<T>> implements ICommand {
    private FamilyTreeView<T> familyTreeView;

    @Override
    public void execute() {
        familyTreeView.quite();
    }

    @Override
    public String discription() {
        return "Выходим...";
    }

}