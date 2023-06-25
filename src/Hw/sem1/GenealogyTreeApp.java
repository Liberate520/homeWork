package Hw.sem1;

public class GenealogyTreeApp {
    public static void main(String[] args) {
        DataStorage<Person> fileHandler = new FileHandler<>();
        FamilyTreePresenter<Person> presenter = new FamilyTreePresenter<>(fileHandler, "family_tree.dat");
        presenter.start();
    }
}
