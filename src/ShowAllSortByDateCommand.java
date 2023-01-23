public class ShowAllSortByDateCommand<T extends LiveBeing<T>> implements ICommand {
    private FamilyTreeView<T> familyTreeView;

    public ShowAllSortByDateCommand(FamilyTreeView<T> familyTreeView) {
        this.familyTreeView = familyTreeView;
    }

    @Override
    public void execute() {
        this.familyTreeView.showAllSortByDate();
    }

    @Override
    public String discription() {
        return "Сортировать по имени и показать";
    }
}
