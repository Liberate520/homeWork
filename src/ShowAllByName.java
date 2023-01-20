public class ShowAllByName<T extends LiveBeing<T>> implements ICommand {
    private FamilyTreeView<T> familyTreeView;

    @Override
    public void execute() {
        familyTreeView.showAllByName();
    }

    @Override
    public String discription() {
        return "Найти объекты по имени и показать все найденные";
    }
}
