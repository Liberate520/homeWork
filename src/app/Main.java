package app;

import analizator.FamilyAnalizer;
import analizator.Pair;
import analizator.TreeAnalizer;
import classes.Parent;
import dataBase.DataBase;
import generator.GenerationWork;

public class Main {
    public static void main(String[] args) {
        // start parameters
        int startPopulation = 3000;
        int generationCount = 10;
        //
        DataBase db = new DataBase();
        GenerationWork Gena = new GenerationWork(db);
        Gena.generatePopulation(startPopulation);
        Gena.startGenerator(generationCount);
        // random person analize
        TreeAnalizer analizer = new TreeAnalizer();

//        System.out.println("\n__________________________________Find children_______________________________");
//        Parent randomPerson = db.getRandomParent();
//
////        String spacer = "";
////        analizer.showChildrenTree(randomPerson, spacer);
//
//        analizer.showChildren(randomPerson);
//
//        System.out.println("\n__________________________________Find siblings_______________________________");
//        Parent randomChild = db.getRandomChild();
//        analizer.showSiblings(randomChild);
//
//        System.out.println("\n__________________________________Find parents________________________________");
//        analizer.showParents(randomChild);
//
//        System.out.println("\n__________________________________All family members__________________________");
//        Parent[] randomFamily = db.getRandomFamily();
//        analizer.showFamilyMembers(randomFamily);

        //families statistics
        FamilyAnalizer familyAnalizer = new FamilyAnalizer(db);
        familyAnalizer.sortByDescendants();
        for (Pair family : familyAnalizer) {
            System.out.println(family.toString());
        }
        familyAnalizer.getChildrenStatistics();
    }
}