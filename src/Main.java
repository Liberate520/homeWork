package java_oop_homeWork.src;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        Kinsman firstKinsman = new Kinsman("Рюрик", Sex.men);
//        System.out.println(firstKinsman);
//        Kinsman secondKinsman = new Kinsman("Анна", Sex.women);
//        FamilyTree familyTree = new FamilyTree("Рюрики", firstKinsman);
//        System.out.println(familyTree);
//        familyTree.printFamily();
//        familyTree.addParent(firstKinsman, secondKinsman);
//        familyTree.printFamily();
//        secondKinsman.printScions();
//
//        //Сериализация в файл с помощью класса ObjectOutputStream
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
//                new FileOutputStream("familyTree.out"));
//        objectOutputStream.writeObject(familyTree);
//        objectOutputStream.writeObject(firstKinsman);
//        objectOutputStream.writeObject(secondKinsman);
//        objectOutputStream.close();

        // Востановление из файла с помощью класса ObjectInputStream
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("familyTree.out"));
        FamilyTree familyTreeRestored = (FamilyTree) objectInputStream.readObject();
        Kinsman firstKinsmanRestored = (Kinsman) objectInputStream.readObject();
        Kinsman secondKinsmanRestored = (Kinsman) objectInputStream.readObject();
        objectInputStream.close();



        System.out.println(familyTreeRestored);
        System.out.println(firstKinsmanRestored);
        System.out.println(secondKinsmanRestored);
    }
}