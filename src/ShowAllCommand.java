public class ShowAllCommand<T extends LiveBeing<T>> implements ICommand {
    private FamilyTreeView<T> familyTreeView;

    public ShowAllCommand(FamilyTreeView<T> familyTreeView) {
        this.familyTreeView = familyTreeView;
    }

    @Override
    public void execute() {
        this.familyTreeView.showAll();
    }

    @Override
    public String discription() {
        return "Показать все объекты дерева";
    }

}
