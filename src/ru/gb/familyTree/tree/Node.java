package ru.gb.familyTree.tree;

import ru.gb.familyTree.person.Person;

import java.util.HashSet;
import java.util.Iterator;

public class Node {
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
        //Сreates Iterator object.
        //Сheck element is present or not. If not loop will break.
        for (Person itm : set) {
            str.append(itm.toString()).append("\n");
        }
        return str.toString();
    }
    @Override
    public String toString() {
        return String.format("Узел дерева %d (брак):\n %s\n и %s\n, их дети:\n %s.",
                getId(),getParentOne().toString(), getParentTwo().toString(), printSet(getChildren()));
    }
}
