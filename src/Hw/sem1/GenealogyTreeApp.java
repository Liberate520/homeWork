package Hw.sem1;

public class GenealogyTreeApp {
    public static void main(String[] args) {
        FamilyTree<Person> familyTree = new FamilyTree<>();
        DataStorage<FamilyTree<Person>> dataStorage = new FileHandler<>();
        FamilyTreePresenter<Person> presenter = new FamilyTreePresenter<>(familyTree, dataStorage);
        presenter.start();
    }
}