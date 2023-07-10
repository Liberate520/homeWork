package familyTree.src.family_tree;

import familyTree.src.family_tree.family_tree1.FamilyTree;
import familyTree.src.family_tree.human.Gender;
import familyTree.src.family_tree.human.Human;
import familyTree.src.family_tree.human.comparators.HumanComparatorByName;

import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();

        tree.add(new Human("45№608202","Мария", Gender.Female, LocalDate.of(1965, 9, 15), "45№705202"));
        tree.add(new Human("45№705202","Василий", Gender.Male, LocalDate.of(1963, 12, 10), "45№608202"));
        tree.add(new Human("18№752-01", "Кристина", Gender.Female, LocalDate.of(1988, 7, 5),
            tree.getByDocId("45№705202"), tree.getByDocId("45№608202")));
        tree.add(new Human("18№144-03", "Семен", Gender.Male, LocalDate.of(1991, 1, 25),
            tree.getByDocId("45№705202"), tree.getByDocId("45№608202")));

        System.out.println(tree.getInfo());
        String path = "src/familyTree/atree.out";
        tree.sortByName();
        System.out.println(tree);
        tree.sortByBirthDate();
        System.out.println(tree);


//        FileGeneration fileGeneration = new FileGeneration();
//        fileGeneration.save(tree, path);

//        FileGeneration fileGeneration = new FileGeneration();
//        FamilyTree atree = (FamilyTree) fileGeneration.read(path);
//        System.out.println(tree);
    }
}
