import com.sun.source.tree.Tree;
import writen.FileHandler;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
//        FamilyTree familyTree = tree();
        FamilyTree familyTree = load();
     System.out.println(familyTree.familyTreeInfo());
//        save(familyTree);
    }

    private static void save(FamilyTree familyTree) {
        String filePath = "src/writen/tree.txt";
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(familyTree, filePath);
    }
    private static FamilyTree load(){
        String filePath = "src/writen/tree.txt";
        FileHandler fileHandler = new FileHandler();
        FamilyTree familyTree = (FamilyTree) fileHandler.read(filePath);
        return familyTree;
    }

    public static FamilyTree tree() {
        FamilyTree familyTree = new FamilyTree();
        Human valery = new Human("Валерий", Gender.Male, LocalDate.of(1952, 6, 6));
        Human nadejda = new Human("Надежда", Gender.Female, LocalDate.of(1952, 2, 8));
        Human ludmila = new Human("Людмила", Gender.Female, LocalDate.of(1973, 5, 17), nadejda, valery);
        Human natali = new Human("Наталия", Gender.Female, LocalDate.of(1977, 3, 30), nadejda, valery);
        Human evgenyi = new Human("Евгений", Gender.Male, LocalDate.of(1993, 8, 16));

        evgenyi.addParent(ludmila);

        familyTree.addFamilyTree(valery);
        familyTree.addFamilyTree(nadejda);
        familyTree.addFamilyTree(ludmila);
        familyTree.addFamilyTree(natali);
        familyTree.addFamilyTree(evgenyi);

        return familyTree;
    }
}