package model;

import java.io.*;
import java.util.*;

public class GenealogyTree<E extends TreeGroupItem> implements Serializable, Iterable<TreeGroupItem>{
    private List<E> humans;

    public GenealogyTree() { this(new ArrayList<>()); }

    public GenealogyTree(List<E> humans) {
        this.humans = humans;
    }


    public boolean addHuman(E human) {
        if (human == null) {
            return false;
        };
        if (!humans.contains(human)){
            humans.add(human);
            if (human.getFather() != null){
                human.getFather().addChild((Human) human);
            }
            if (human.getMother() != null){
                human.getMother().addChild((Human) human);
            }
            return true;
        }
        return false;
    }



    public void printTree(String tab, Human human) {
        System.out.println(tab + human.toString());
        List<E> children = (List<E>) human.getChildrens();
        for (E child : children) {
            printTree("   ", (Human) child); // КОСТЫЛЬ!!!
        }
    }


    @Override
    public Iterator<TreeGroupItem> iterator() { return (Iterator<TreeGroupItem>) new HumanIterator<E>(humans); }

    public void sortByName(){
        humans.sort(new HumanComparatorByName<E>());
    }
    public void sortByAge(){
        humans.sort(new HumanComparatorByAge<E>());
    }
}