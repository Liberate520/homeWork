import model.familyTree.FamilyTree;
import model.human.Gender;
import model.human.Human;
import model.service.FamilyTreeService;
import view.ConsoleUI;
import view.View;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
//        FileHandler fileHandler = new FileHandler();

        FamilyTree<Human> tree = testTree();
        FamilyTreeService service = new FamilyTreeService(tree);

        View view = new ConsoleUI();
        view.getPresenter().setService(service);
        view.start();

//        FamilyTree tree = testTree();
//        System.out.println(tree);
//
//        tree.sortByFullName();
//        System.out.println(tree);
//
//        tree.sortByAge();
//        System.out.println(tree);
//
//        tree.sortByBirthDate();
//        System.out.println(tree);


//        fileHandler.save(tree, "src/Serializable/tree.out");
//        FileHandler fileHandler = new FileHandler();
//        FamilyTree tree = (FamilyTree) fileHandler.read("src/Serializable/tree.out");
//        System.out.println(tree);
    }

    static FamilyTree testTree() {
        FamilyTree tree = new FamilyTree();

        tree.add(new Human("Дроздов", "С", "Н", Gender.Male, LocalDate.of(1949, 4, 4),
                LocalDate.of(1986, 7, 8)));
        tree.add(new Human("Карманова", "Л", "В", Gender.Female, LocalDate.of(1949, 9, 9)));
        tree.add(new Human("Дроздов", "А", "С", Gender.Male, LocalDate.of(1980, 6, 7),
                (Human) tree.getByName("Дроздов", "С", "Н"), (Human) tree.getByName("Карманова", "Л", "В")));
        tree.add(new Human("Дроздова", "С", "В", Gender.Female, LocalDate.of(1986, 4, 10)));
        tree.add(new Human("Дроздова", "В", "А", Gender.Female, LocalDate.of(2010, 2, 20),
                (Human) tree.getByName("Дроздов", "А", "С"), (Human) tree.getByName("Дроздова", "С", "В")));
        tree.add(new Human("Дроздов", "Ю", "А", Gender.Male, LocalDate.of(2014, 2, 2),
                (Human) tree.getByName("Дроздов", "А", "С"), (Human) tree.getByName("Дроздова", "С", "В")));
        return tree;
    }
}
