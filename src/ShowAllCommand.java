public class ShowAllCommand<T extends LiveBeing<T>> implements ICommand {
    private FamilyTreeView<T> familyTreeView;

    @Override
    public void execute() {
        familyTreeView.showAll();
    }

    @Override
    public String discription() {
        return "Показать все объекты дерева";
    }

}
