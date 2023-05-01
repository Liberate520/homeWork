package java_oop_homeWork.src;

import java_oop_homeWork.src.familyTree.FamilyTree;
import java_oop_homeWork.src.kinsman.Kinsman;
import java_oop_homeWork.src.kinsman.Sex;
import java_oop_homeWork.src.serialization.FileHandler;
import java_oop_homeWork.src.serialization.Writeble;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String filePath = "FamilyTree.out";
        Writeble writeble = new FileHandler();
        Kinsman firstKinsman = new Kinsman("Рюрик", "Рюрикович", Sex.men,"01.01.0840", "01.01.0879");
        System.out.println(firstKinsman);
        Kinsman secondKinsman = new Kinsman("Ольга", "Рюрикович", Sex.women, "01.01.0893", "01.01.0969");
        Kinsman thirdKinsman = new Kinsman("Игорь", "Рюрикович", Sex.men, "01.01.0878", "01.01.0945");
        Kinsman fourKinsman = new Kinsman("Святослав", "Рюрикович", Sex.men, "01.01.0920", "01.01.0972");
        FamilyTree<Kinsman> familyTree = new FamilyTree("Рюрики", firstKinsman);
//        familyTree = (FamilyTree) writeble.read(filePath);
        familyTree.addChild(firstKinsman, thirdKinsman);
        familyTree.addChild(thirdKinsman, fourKinsman);
        familyTree.printFamily();
        familyTree.addParent(fourKinsman, secondKinsman);
        familyTree.addParent(thirdKinsman, firstKinsman);

        writeble.write(familyTree, filePath);

        System.out.println(familyTree.getInfo());
        familyTree.printFamily();
        System.out.println("----");
        familyTree.printFamily(familyTree.sortByName());
        System.out.println("----");
        familyTree.printFamily(familyTree.sortByDateBirth());
    }

}