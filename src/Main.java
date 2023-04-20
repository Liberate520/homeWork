package java_oop_homeWork.src;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Kinsman firstKinsman = new Kinsman("Рюрик", "Рюрикович", Sex.men, "01.01.0879");
        System.out.println(firstKinsman);
        Kinsman secondKinsman = new Kinsman("Ольга", "Рюрикович", Sex.women, "01.01.0893", "01.01.0969");
        Kinsman thirdKinsman = new Kinsman("Игорь", "Рюрикович", Sex.men, "01.01.0878", "01.01.0945");
        Kinsman fourKinsman = new Kinsman("Святослав", "Рюрикович", Sex.men, "01.01.0920", "01.01.0972");
        FamilyTree familyTree = new FamilyTree("Рюриковичи", firstKinsman);
        System.out.println(familyTree);
        familyTree.printFamily();
        familyTree.addChild(firstKinsman, thirdKinsman);
        familyTree.addChild(thirdKinsman, fourKinsman);
        familyTree.printFamily();
        familyTree.addParent(fourKinsman, secondKinsman);
        familyTree.addParent(thirdKinsman, firstKinsman);
        System.out.println(familyTree);
        firstKinsman.getFamily().printFamily();
        secondKinsman.printChilds();

        //Сериализация в файл с помощью класса ObjectOutputStream
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("familyTree.out"));
        objectOutputStream.writeObject(familyTree);
        objectOutputStream.writeObject(firstKinsman);
        objectOutputStream.writeObject(secondKinsman);
        objectOutputStream.writeObject(thirdKinsman);
        objectOutputStream.writeObject(fourKinsman);
        objectOutputStream.close();

        // Востановление из файла с помощью класса ObjectInputStream
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("familyTree.out"));
        FamilyTree familyTreeRestored = (FamilyTree) objectInputStream.readObject();
        Kinsman firstKinsmanRestored = (Kinsman) objectInputStream.readObject();
        Kinsman secondKinsmanRestored = (Kinsman) objectInputStream.readObject();
        Kinsman thirdKinsmanRestored = (Kinsman) objectInputStream.readObject();
        Kinsman fourKinsmanRestored = (Kinsman) objectInputStream.readObject();
        objectInputStream.close();



        System.out.println(familyTreeRestored);
        System.out.println(firstKinsmanRestored);
        System.out.println(secondKinsmanRestored);
        System.out.println(thirdKinsmanRestored);
        System.out.println(fourKinsmanRestored);
    }
}