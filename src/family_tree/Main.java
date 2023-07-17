package family_tree;

import family_tree.model.family_tree.FamilyTree;
import family_tree.model.human.Human;
import family_tree.model.human.Sex;
import family_tree.model.writer.FileHandler;
import family_tree.presenter.Presenter;
import family_tree.view.ConsoleView;
import family_tree.view.View;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleView();
        FileHandler fileHandler = new FileHandler();
        Presenter presenter = new Presenter(view, fileHandler);

        // Создание примера семейного дерева
        FamilyTree<Human> familyTree = new FamilyTree<>();
        Human ivanPetrov = new Human("Ivan Petrov", Sex.Male, LocalDate.of(1954, 10, 11));
        Human elizavetaKashina = new Human("Elizaveta Kashina", Sex.Female, LocalDate.of(1959, 1, 19));

        familyTree.add(ivanPetrov);
        familyTree.add(elizavetaKashina);
        familyTree.add(new Human("Ekaterina Myasnikova", Sex.Female, LocalDate.of(1975, 12, 26),
                List.of(ivanPetrov, elizavetaKashina)));
        familyTree.add(new Human("Petr Shishkin", Sex.Male, LocalDate.of(1981, 5, 21),
                List.of(ivanPetrov, elizavetaKashina)));

        presenter.setFamilyTree(familyTree);

        // Демонстрация работы функциональности
        presenter.displayFamilyTreeInfo();
        presenter.sortByBirthDate();
        presenter.displayFamilyTreeInfo();
        presenter.sortByName();
        presenter.displayFamilyTreeInfo();

        // Сохранение и загрузка семейного дерева
        String filePath = "family_tree.ser";
        presenter.saveFamilyTree(filePath);
        presenter.clearFamilyTree();
        presenter.loadFamilyTree(filePath);
        presenter.displayFamilyTreeInfo();
    }
}
