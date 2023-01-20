public class LoadFromBin<T extends LiveBeing<T>> implements ICommand {
    private FamilyTreeView<T> familyTreeView;

    @Override
    public void execute() {
        familyTreeView.loadFromBin();

    }

    @Override
    public String discription() {
        return "Загрузить из бинарного файла.";
    }

}