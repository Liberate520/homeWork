package java_oop_homeWork.src;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String filePath = "FamilyTree.out";
        Writeble writeble = new FileHandler();

//        Kinsman firstKinsman = new Kinsman("Рюрик", "Рюрикович", Sex.men, "01.01.0879");
//        System.out.println(firstKinsman);
//        Kinsman secondKinsman = new Kinsman("Ольга", "Рюрикович", Sex.women, "01.01.0893", "01.01.0969");
//        Kinsman thirdKinsman = new Kinsman("Игорь", "Рюрикович", Sex.men, "01.01.0878", "01.01.0945");
//        Kinsman fourKinsman = new Kinsman("Святослав", "Рюрикович", Sex.men, "01.01.0920", "01.01.0972");
        FamilyTree familyTree = (FamilyTree) writeble.read(filePath);
        System.out.println(familyTree);
        familyTree.printFamily();
//        familyTree.addChild(firstKinsman, thirdKinsman);
//        familyTree.addChild(thirdKinsman, fourKinsman);
//        familyTree.printFamily();
//        familyTree.addParent(fourKinsman, secondKinsman);
//        familyTree.addParent(thirdKinsman, firstKinsman);

        familyTree.printFamily();

        writeble.write(familyTree, filePath);
        FamilyTree familyTreeRelated = (FamilyTree) writeble.read(filePath);
        System.out.println(familyTreeRelated.getInfo());
    }
}