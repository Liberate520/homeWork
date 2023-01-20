public class SaveToBin<T extends LiveBeing<T>> implements ICommand {
    private FamilyTreeView<T> familyTreeView;

    @Override
    public void execute() {
        familyTreeView.saveToBin();

    }

    @Override
    public String discription() {
        return "Сохранить в бинарный файл.";
    }

}
