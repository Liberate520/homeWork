package org.genealogy.model.service;

import org.genealogy.model.person.Human;
import org.genealogy.model.tree.GenealogyTree;
import org.genealogy.model.tree.TreeItem;
import java.util.Iterator;

public class Service<E extends TreeItem> extends GenealogyTree<E>{
    private GenealogyTree<E> tree;
    public Service() {
        tree = new GenealogyTree<>();
    }

    public void addHuman(String firstName, String lastName)
    {
        Human human = new Human(firstName, lastName);
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
}
