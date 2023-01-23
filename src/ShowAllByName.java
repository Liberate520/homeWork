public class ShowAllByName<T extends LiveBeing<T>> implements ICommand {
    private FamilyTreeView<T> familyTreeView;

    public ShowAllByName(FamilyTreeView<T> familyTreeView) {
        this.familyTreeView = familyTreeView;
    }

    @Override
    public void execute() {
        this.familyTreeView.showAllByName();
    }

    @Override
    public String discription() {
        return "Найти объекты по имени и показать все найденные";
    }
}
