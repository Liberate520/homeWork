package ru.gb.familyTree.tree;

import ru.gb.familyTree.person.Gender;
import ru.gb.familyTree.person.Person;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;

public class Node implements Serializable {
    private int id;
    private FamilyTree family;
    private Person parentOne;
    private Person parentTwo;
    private HashSet<Person> children;

    public Node(int id, FamilyTree family, Person parentOne, Person parentTwo, HashSet<Person> children){
        this.setId(id);
        this.setFamily(family);
        this.setParentOne(parentOne);
        this.setParentTwo(parentTwo);
        this.setChildren(children);
    }

    public void clear (){
        this.setFamily(null);
        this.setId(0);
        this.setParentOne(null);
        this.setParentTwo(null);
        this.setChildren(new HashSet<Person>());
    }

    public void setId(int id){
        this.id = id;
    }
    public void setFamily(FamilyTree family){
        this.family = family;
    }

    public void setParentOne(Person parentOne){
        this.parentOne = parentOne;
    }

    public void setParentTwo(Person parentTwo){
        this.parentTwo = parentTwo;
    }

    public void setChildren(HashSet<Person> children){
        this.children = children;
    }

    public void addChildren(Person child){
        this.children.add(child);
    }

    public int getId(){
        return id;
    }

    public FamilyTree getFamily(){
        return family;
    }

    public Person getParentOne(){
        return parentOne;
    }

    public Person getParentTwo(){
        return parentTwo;
    }

    public HashSet<Person> getChildren(){
        return children;
    }


    /**
     * Выводит на экран содержимое HashSet
     */
    private String printSet(HashSet<Person> set) {
        StringBuilder str = new StringBuilder();
        for (Person itm : set) {
            str.append(itm.toString()).append("\n");
        }
        return str.toString();
    }
    @Override
    public String toString() {
        return String.format("Узел дерева %d (брак):\n%s и %s,\nих дети:\n%s\n",
                getId(),getParentOne().toString(), getParentTwo().toString(), printSet(getChildren()));
    }
}
