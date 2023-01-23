public class SaveToBin<T extends LiveBeing<T>> implements ICommand {
    private FamilyTreeView<T> familyTreeView;

    public SaveToBin(FamilyTreeView<T> familyTreeView) {
        this.familyTreeView = familyTreeView;
    }

    @Override
    public void execute() {
        this.familyTreeView.saveToBin();

    }

    @Override
    public String discription() {
        return "Сохранить в бинарный файл.";
    }

}
