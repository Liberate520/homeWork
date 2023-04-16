package model;

import model.Human.Human;
import model.tree.FamilyTree;
import model.tree.comparators.HumanComparatorByDateOfBirth;
import model.tree.comparators.HumanComparatorByName;
import java.io.*;
import java.time.LocalDate;


public class FamilyTreeService implements Writeable {
    private final FamilyTree<Human> tree;
    public FamilyTreeService(FamilyTree<Human> tree) {
        this.tree = tree;
    }
    public void sortByName(){
        tree.getTree().sort(new HumanComparatorByName());
    }

    public void sortByDateOfBirht(){
        tree.getTree().sort(new HumanComparatorByDateOfBirth());
    }
    @Override
    public void save() {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("data.txt"));
            objectOutputStream.writeObject(tree);
            objectOutputStream.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("data.txt"));
//        objectOutputStream.writeObject(o);
//        objectOutputStream.close();
    }
    @Override
    public void read() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("data.txt"));
            Object ob = objectInputStream.readObject();
            objectInputStream.close();
            System.out.println(ob);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
//        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("data.txt"));
//        Object ob = objectInputStream.readObject();
//        objectInputStream.close();
//        System.out.println(ob);
    }
    public void addHuman(String name, String surname, LocalDate dayOfBirth) {
        FamilyTree<Human> tree = new FamilyTree<>();
        tree.add(new Human(name,surname,dayOfBirth));
    }

    @Override
    public String toString() {
        return "" + tree;
    }

    public void showWithIter() {
        for (Object human: tree) {
            System.out.println(human);
        }
    }

    public void search(String name, String surname) {
        tree.searchForSurnameAndName(name, surname);
    }
}
