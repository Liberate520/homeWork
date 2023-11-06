import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = testTree();
//        FamilyTree tree = load();
        System.out.println(tree);
        save(tree);
    }

//    private static FamilyTree load () {
//        FileHandler fileHandler = new FileHandler();
//        String filePath = "src/tree.txt";
//        return (FamilyTree) fileHandler.read(filePath);
//    }
    private static  void save (FamilyTree tree) {
        FileHandler fileHandler = new FileHandler();
        String filePath = "src/tree.txt";
        fileHandler.save(tree, filePath);
    }
    static FamilyTree testTree () {
        FamilyTree tree = new FamilyTree();
        Human vasya = new Human("Василий", Gender.Male, LocalDate.of(1963, 12, 10));
        Human masha = new Human("Мария", Gender.Female, LocalDate.of(1965, 9, 15));
        tree.add(vasya);
        tree.add(masha);
        tree.setWedding(vasya, masha);
        Human christina = new Human("Кристина", Gender.Female, LocalDate.of(1988, 7,5), vasya, masha);
        Human semyon = new Human("Семён", Gender.Male, LocalDate.of(1991, 1, 25), vasya, masha);
        tree.add(christina);
        tree.add(semyon);
        Human larisa = new Human("Лариса", Gender.Female, LocalDate.of(1945, 9, 1));
        larisa.addChild(vasya);
        tree.add(larisa);
        return tree;
    }
}
