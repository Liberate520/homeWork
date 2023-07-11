package org.genealogy.model.service;

import org.genealogy.model.person.Animal;
import org.genealogy.model.person.Dog;
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
        tree.addPerson(human);
    }

    public void addDog(String firstName)
    {
        Dog dog = new Dog(firstName);
        tree.addPerson(dog);
    }

    public void showTree() {
        for (Object animal : tree){
            System.out.println(animal);
        }
        System.out.println();
    }

    //  Iterator
    public String getTreeInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список людей:\n");
        Iterator<Animal> iterator = tree.iterator();
        while (iterator.hasNext()) {
            Animal animal = iterator.next();
            stringBuilder.append(animal);
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
