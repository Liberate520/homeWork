package org.genealogy.model.service;

import org.genealogy.model.person.Human;
import org.genealogy.model.tree.GenealogyTree;

import java.util.Iterator;

public class Service {
    private GenealogyTree tree;
    public Service() {
        tree = new GenealogyTree();
    }

    public void addHuman(String firstName, String lastName)
    {
        Human human = new Human(firstName, lastName);
        tree.addHuman(human);
    }

    //  Iterator
    public String getTreeInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список людей:\n");
        Iterator<Human> iterator = tree.iterator();
        while (iterator.hasNext()) {
            Human human = iterator.next();
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
}
