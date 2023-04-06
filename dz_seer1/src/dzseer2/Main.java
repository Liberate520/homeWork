package dzseer2;

import dzseer2.human.Human;
import dzseer2.tree.Adding_a_person;
import dzseer2.tree.FamilyTree;


import java.io.*;
import java.util.List;
public class Main {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
        System.out.println("\nПолный список людей: 999");
        Adding_a_person collection = new Adding_a_person();
        List<Human> humanList = collection.fillCollection();
        for (Human human : humanList) {
            System.out.println( human);
        }
        System.out.println("\nСформированный список семьи: 777");
        FamilyTree tree = new FamilyTree();
        List<Human> humanFamilyList = tree.familyCollection(humanList);
        for (Human familyHuman : humanFamilyList){
            System.out.println(familyHuman);
        }
        System.out.println("\nДети искомой семьи: 555");
        FamilyTree tree1 = new FamilyTree();
        List<Human> humanFamilyList1 = tree1.getSearchForChildren(humanFamilyList);
        for (Human familyHuman : humanFamilyList1){
            System.out.println(familyHuman);
        }
        System.out.println("\nРодители искомой семьи: 333");
        FamilyTree tree2 = new FamilyTree();
        List<Human> humanFamilyList2 = tree1.getSearchForParents(humanFamilyList);
        for (Human familyHuman : humanFamilyList2){
            System.out.println(familyHuman);
        }

        Adding_a_person collection1 = new Adding_a_person();
        List<Human> humanList1 = collection1.fillCollection();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("pers.out"));
        for (Human human : humanList1) {
            objectOutputStream.writeObject(human);
        }
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("pers.out"));
        for (Human human : humanList1) {
            Human humanRestored = (Human) objectInputStream.readObject();
        }
        objectInputStream.close();
    }
}
