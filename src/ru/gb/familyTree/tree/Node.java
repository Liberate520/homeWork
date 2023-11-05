package ru.gb.familyTree.tree;

import ru.gb.familyTree.person.Person;
import java.io.Serializable;
import java.util.HashSet;

public class Node<E1, E2> implements Serializable {
    private E1 id;
    private FamilyTree family;
    private E2 parentOne;
    private E2 parentTwo;
    private HashSet<E2> children;

    public Node(E1 id, FamilyTree family, E2 parentOne, E2 parentTwo, HashSet<E2> children){
        this.setId(id);
        this.setFamily(family);
        this.setParentOne(parentOne);
        this.setParentTwo(parentTwo);
        this.setChildren(children);
    }

    public void clear (){
        this.setFamily(null);
        this.setId(null);
        this.setParentOne(null);
        this.setParentTwo(null);
        this.setChildren(new HashSet<>());
    }

    public void setId(E1 id){
        this.id = id;
    }
    public void setFamily(FamilyTree family){
        this.family = family;
    }

    public void setParentOne(E2 parentOne){
        this.parentOne = parentOne;
    }

    public void setParentTwo(E2 parentTwo){
        this.parentTwo = parentTwo;
    }

    public void setChildren(HashSet<E2> children){
        this.children = children;
    }

    public void addChildren(E2 child){
        this.children.add(child);
    }

    public E1 getId(){
        return id;
    }

    public FamilyTree getFamily(){
        return family;
    }

    public E2 getParentOne(){
        return parentOne;
    }

    public E2 getParentTwo(){
        return parentTwo;
    }

    public HashSet<E2> getChildren(){
        return children;
    }


    /**
     * Выводит на экран содержимое HashSet
     */
    private String printSet(HashSet<E2> set) {
        StringBuilder str = new StringBuilder();
        for (E2 itm : set) {
            str.append(itm.toString()).append("\n");
        }
        return str.toString();
    }
    @Override
    public String toString() {
        return String.format("Узел дерева %d :\n%s и %s,\nих дети:\n%s\n",
                getId(),getParentOne().toString(), getParentTwo().toString(), printSet(getChildren()));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Node node)){
            return false;
        }
        return  family.equals(node.getFamily()) &&
                ((parentOne != null ? parentOne.equals(node.getParentOne()): true) ||
                        (parentOne != null ? parentOne.equals(node.getParentTwo()): true)) &&
                ((parentTwo != null ? parentTwo.equals(node.getParentTwo()): true) ||
                        (parentTwo != null ? parentTwo.equals(node.getParentOne()): true));
    }
}
