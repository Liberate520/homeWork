public class ShowAllSortByNameCommand<T extends LiveBeing<T>> implements ICommand {
    private FamilyTreeView<T> familyTreeView;

    @Override
    public void execute() {
        familyTreeView.showAllSortByName();
    }

    @Override
    public String discription() {
        return "Сортировать по имени и показать";
    }

}
