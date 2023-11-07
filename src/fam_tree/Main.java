package fam_tree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = tree();

        System.out.println(familyTree.familyTreeInfo());
        save(familyTree);
    }

    private static void save(FamilyTree familyTree) {
        String filePath = "src/fam_tree/tree.txt";
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(familyTree, filePath);
    }
    private static FamilyTree load(){
        String filePath = "src/fam_tree/tree.txt";
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree) fileHandler.read(filePath);
    }

    public static FamilyTree tree() {
        FamilyTree familyTree = new FamilyTree();
        Human vlad = new Human("Влад", Gender.Male, LocalDate.of(1952, 6, 6));
        Human sveta = new Human("Светлана", Gender.Female, LocalDate.of(1952, 2, 8));
        Human inna = new Human("Инна", Gender.Female, LocalDate.of(1973, 5, 17), sveta, vlad);
        Human valya = new Human("Валентина", Gender.Female, LocalDate.of(1977, 3, 30), sveta, vlad);
        Human leks = new Human("Алексей", Gender.Male, LocalDate.of(1993, 8, 16));

        leks.addParent(inna);

        familyTree.addFamilyTree(vlad);
        familyTree.addFamilyTree(sveta);
        familyTree.addFamilyTree(inna);
        familyTree.addFamilyTree(valya);
        familyTree.addFamilyTree(leks);

        return familyTree;
    }
}
