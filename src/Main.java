import writer.FileHandler;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Human human1 = new Human("Петр", "Сидоров", Gender.male,LocalDate.of(1903, 11,11));
        Human human2 = new Human("Вера", "Иванова", Gender.female, LocalDate.of(1905, 4,1));
        Human human3 = new Human("Павел", "Сидоров", Gender.male, LocalDate.of(1925, 3,5), human2, human1);
        Human human4 = new Human("Нина", "Сидорова", Gender.female, LocalDate.of(1927, 12,15), human2, human1);
        Human human5 = new Human("Инна", "Петрова", Gender.female,LocalDate.of(1926, 4,3));
        Human human6 = new Human("Иван", "Сидоров", Gender.female, LocalDate.of(1947, 11,6), human5, human3);

        FamilyTree tree1 = new FamilyTree(human1);
        FamilyTree tree2 = new FamilyTree(human2);

        human6.setDeathData(LocalDate.of(1995, 3,16));
        System.out.println(human6.fullInfo());

        System.out.println(human1);
        System.out.println(human2);
        System.out.println(human3);

        System.out.println(tree1);
        System.out.println(tree2);

        FileHandler fileHandler = new FileHandler();
        fileHandler.save(tree1);
        tree1 = null;
        System.out.println(tree1);
        tree1 = (FamilyTree) fileHandler.load();
        System.out.println(tree1);
    }
}
