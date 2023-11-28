package fam_tree.main;

import fam_tree.family_tree.FamilyTree;
import fam_tree.file_handler.FileHandler;
import fam_tree.valet.Look;
import fam_tree.valet.Valet;

public class Main {
    public static void main(String[] args) {
        Valet valet = new Valet();
        Look look = new Look() {
            @Override
            public void start() {

            }
        };
        look.start();
    }

//        FamilyTree familyTree = tree();
////        FamilyTree tree = load();
////        System.out.println(tree);
//
//        System.out.println(familyTree.familyTreeInfo());
//        save(familyTree);
//    }
//
    private static void save(FamilyTree familyTree) {
        String filePath = "src/fam_tree/tree.txt";
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(familyTree, filePath);
    }
    private static FamilyTree load(){
        String filePath = "src/fam_tree/tree.txt";
        FileHandler fileHandler = new FileHandler();
        FamilyTree tree = (FamilyTree) fileHandler.read(filePath);
        return tree;
    }
//
//    public static FamilyTree tree() {
//        FamilyTree familyTree = new FamilyTree();
//        Human vlad = new Human("Влад", Gender.Male, LocalDate.of(1952, 6, 6));
//        Human sveta = new Human("Светлана", Gender.Female, LocalDate.of(1952, 2, 8));
//        Human inna = new Human("Инна", Gender.Female, LocalDate.of(1973, 5, 17), sveta, vlad);
//        Human valya = new Human("Валентина", Gender.Female, LocalDate.of(1977, 3, 30), sveta, vlad);
//        Human leks = new Human("Алексей", Gender.Male, LocalDate.of(1993, 8, 16));
//
//        leks.addParent(inna);
//
//        familyTree.addFamilyTree(vlad);
//        familyTree.addFamilyTree(sveta);
//        familyTree.addFamilyTree(inna);
//        familyTree.addFamilyTree(valya);
//        familyTree.addFamilyTree(leks);
//        familyTree.familyTreeInfo();
//        System.out.println(familyTree.familyTreeInfo());

//        System.out.println(familyTree);






    




}
