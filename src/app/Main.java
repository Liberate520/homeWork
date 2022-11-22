package app;

import analizator.Treeanalizer;
import classes.Parent;
import dataBase.DataBase;
import generator.GenerationWork;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // start parameteres
        int startPopulation = 3000;
        int generationCount = 9;
        //
        DataBase db = new DataBase();
        GenerationWork Gena = new GenerationWork(db);
        Gena.generatePopulation(startPopulation);
        Gena.startGenerator(generationCount);
        // random person analize
        Treeanalizer analizer = new Treeanalizer();

        System.out.println("\n__________________________________Find children_______________________________");
        Parent randomPerson = db.getRandomParent();

//        String spacer = "";
//        analizer.showChildrenTree(randomPerson, spacer);

        analizer.showChildren(randomPerson);

        System.out.println("\n__________________________________Find siblings_______________________________");
        Parent randomChild = db.getRandomChild();
        analizer.showSiblings(randomChild);

        System.out.println("\n__________________________________Find parents________________________________");
        analizer.showParents(randomChild);

        System.out.println("\n__________________________________All family members__________________________");
        Parent[] randomFamily = db.getRandomFamily();
        analizer.showFamilyMembers(randomFamily);
    }
}