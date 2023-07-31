import java.time.LocalDate;
import java.util.List;
import java.io.IOException;

public class Main implements FamilyTreeView {
    private FamilyTreeModel model;
    private static FamilyTree<Human> familyTree;

    public Main() {
        model = new FamilyTreeModel();
    }

    public void addHumanToFamilyTree(Human human) {
        model.addHuman(human);
    }

    public void fetchChildrenOfFather(Human father) {
        List<Human> children = model.getChildrenOfFather(father);
        showChildrenOfFather(children);
    }

    public void fetchChildrenOfMother(Human mother) {
        List<Human> children = model.getChildrenOfMother(mother);
        showChildrenOfMother(children);
    }

    @Override
    public void showChildrenOfFather(List<Human> children) {
        System.out.println("Children of Father:");
        for (Human child : children) {
            System.out.println(child.getFirstName() + " " + child.getLastName());
        }
    }

    @Override
    public void showChildrenOfMother(List<Human> children) {
        // Update the UI to show the children of the mother.
        // For example, display a list of children's names.
        System.out.println("Children of Mother:");
        for (Human child : children) {
            System.out.println(child.getFirstName() + " " + child.getLastName());
        }
    }
    public static void main(String[] args) {
        Main main = new Main();
        
        // Создаем несколько объектов Human
        Human father = new Human("Oleg", "Ivanov", LocalDate.of(1970, 5, 10), Gender.MALE);
        Human mother = new Human("Olga", "Ivanova", LocalDate.of(1975, 8, 15), Gender.FEMALE);
        Human child1 = new Human("Elena", "Ivanova", LocalDate.of(1995, 3, 20), Gender.FEMALE);
        Human child2 = new Human("Artem", "Ivanov", LocalDate.of(1998, 7, 5), Gender.MALE);

        // Устанавливаем отцов и матерей
        child1.setFather(father);
        child1.setMother(mother);
        child2.setFather(father);
        child2.setMother(mother);

        main.addHumanToFamilyTree(father);
        main.addHumanToFamilyTree(mother);
        main.addHumanToFamilyTree(child1);
        main.addHumanToFamilyTree(child2);

        main.fetchChildrenOfFather(father);
        main.fetchChildrenOfMother(mother);

        // Определяем связи между родителями и детьми с помощью класса Communications
        Communications relationship1 = new Communications(father, child1, "Father-Daughter");
        Communications relationship2 = new Communications(mother, child1, "Mother-Daughter");
        Communications relationship3 = new Communications(father, child2, "Father-Son");
        Communications relationship4 = new Communications(mother, child2, "Mother-Son");

        // Выводим информацию о связях
        System.out.println(relationship1);
        System.out.println(relationship2);
        System.out.println(relationship3);
        System.out.println(relationship4);

        // Создаем FamilyTree и добавляем людей
        // FamilyTree<Human> familyTree = new FamilyTree<>();
        // familyTree.addHuman(father);
        // familyTree.addHuman(mother);
        // familyTree.addHuman(child1);
        // familyTree.addHuman(child2);

        // Сохраняем FamilyTree в файл
        FileHandler<Human> fileHandler = new FileHandler<>(familyTree);
        try {
            fileHandler.saveToFile("family_tree_data.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Чтение FamilyTree из файла
        FamilyTree<Human> loadedFamilyTree = new FamilyTree<>();
        FileHandler<Human> loadedFileHandler = new FileHandler<>(loadedFamilyTree);
        try {
            loadedFileHandler.loadFromFile("family_tree_data.ser");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Теперь loadedFamilyTree содержит те же данные, что и familyTree

        // Проверяем отношения
        System.out.println("Father: " + child1.getFather());
        System.out.println("Mother: " + child1.getMother());

        // Используем методы getChildrenOfFather и getChildrenOfMother
        List<Human> childrenOfFather = familyTree.getChildrenOfFather(father);
        List<Human> childrenOfMother = familyTree.getChildrenOfMother(mother);

        System.out.println("Children of Father:");
        for (Human child : childrenOfFather) {
            System.out.println(child);
        }

        System.out.println("Children of Mother:");
        for (Human child : childrenOfMother) {
            System.out.println(child);
        }
    }
        
}



