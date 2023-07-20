package org.genealogy.model.service;

import org.genealogy.model.person.Gender;
import org.genealogy.model.person.Human;
import org.genealogy.model.tree.GenealogyTree;
import org.genealogy.model.tree.TreeItem;
import org.genealogy.model.tree.fileHandler.SaveLoadFile;
import org.genealogy.model.tree.fileHandler.Writeable;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class Service<E extends TreeItem> extends GenealogyTree<E> {
    private GenealogyTree tree;
    private int count;

    public Service() {
        tree = new GenealogyTree<>();
        count = 0;
    }

    public void addHuman(String firstName, String lastName) throws IOException {
        Human human = new Human(firstName, lastName);
        human.setId(count);
        count++;
        FileWriter a = new FileWriter("counter.txt");
        String s = Integer.toString(count);
        a.write(s);
        a.close();
        tree.addHuman((E) human);
    }

    //  Iterator
    public String getTreeInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список людей:\n");
        Iterator<E> iterator = tree.iterator();
        while (iterator.hasNext()) {
            E human = iterator.next();
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName(){
        tree.sortByName();
    }

    public void sortByAge(){
        tree.sortByAge();
    }

    public void addDateOfBirth(int id, int day, int month, int year) {
        tree.addDateOfBirth(id, day, month, year);
    }

    public void addDateOfDeath(int id, int day, int month, int year) {
        tree.addDateOfDeath(id, day, month, year);
    }

    public void addGender(int id, Gender gender) {
        tree.addGender(id, gender);
    }


    public void addChildren(int parentId, int childId) {
        tree.addChildren(parentId, childId);
    }

    public void saveTreeToFile() throws IOException {
        Writeable save = new SaveLoadFile();
        save.saveToFile("family_tree.txt", tree);
    }

    public void loadTreeFromFile() throws IOException, ClassNotFoundException {
        Writeable load = new SaveLoadFile();
        this.tree = load.loadFromFile("family_tree.txt");
        FileReader a = new FileReader("counter.txt");
        Scanner scanner = new Scanner(a);
        int n = 0;
        while (scanner.hasNextInt()) {
            n = scanner.nextInt();
        }
        scanner.close();
        count = n;
        System.out.println(n + " -----------");
        a.close();
    }
}
