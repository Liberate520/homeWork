package app;

import dataBase.DataBase;
import generator.GenerationWork;

import java.io.IOException;

import analizator.Treeanalizer;
import classes.Parent;
import classes.Human;

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
        System.out.println("\n__________________________________Find children_______________________________");
        Parent randomPerson = db.getRandomParent();
//        String spacer = "";
//        Treeanalizer.showChildrenTree(randomPerson, spacer);
        Treeanalizer.showChildren(randomPerson);
        System.out.println("\n__________________________________Find siblings_______________________________");
        Human randomChild = db.getRandomChild();
        Treeanalizer.showSiblings(randomChild);
        System.out.println("\n__________________________________Find parents________________________________");
        Treeanalizer.showParents(randomChild);

        System.out.println("\n__________________________________All family members__________________________");
        Human[] randomFamily = db.getRandomFamily();
        Treeanalizer.showFamilyMembers(randomFamily);
    }
}