import model.human.Gender;
import model.human.Human;
import model.familyTree.FamilyTree;
import model.writer.FileHandler;

import java.io.Serializable;
import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
//        FamilyTree tree = new FamilyTree();
//        Human parent1 = new Human("Bob", "Marston", Gender.MALE, LocalDate.of(1843, 12, 25));
//        Human parent2 = new Human("Kate", "Potter", Gender.FEMALE, LocalDate.of(1850, 11, 4));
//
//        tree.add(parent1);
//        tree.add(parent2);
//        tree.setWedding(parent1, parent2);
//
//        Human child1 = new Human("Ron", "Marston", Gender.MALE, LocalDate.of(1880, 5, 12), parent1, parent2);
//        Human child2 = new Human("Jenny", "Marston", Gender.FEMALE, LocalDate.of(1884, 12, 25), parent1, parent2);
//
//        tree.add(child1);
//        tree.add(child2);
//        System.out.println(tree);

        FamilyTree tree = load();
        System.out.println(tree);
    }

    private static FamilyTree load(){
        String filePath = "src/model/writer/tree.txt";
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree) fileHandler.read(filePath);
    }
    private static void save(FamilyTree tree){
        String filePath = "src/model/writer/tree.txt";
        FileHandler fileHandler = new FileHandler();
        fileHandler.save((Serializable) tree, filePath);
    }
}
