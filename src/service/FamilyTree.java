package service;

import service.comporators.HumanComporatorByChild;
import service.comporators.HumanComporatorByName;
import service.human.Human;
import service.human.HumanIterator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends Human> implements Serializable, Iterable<E>{
    private List<E> familyTree;
    public FamilyTree(List<E> familyTree) {
        this.familyTree = familyTree;
    }
    public  FamilyTree()
    {
        this(new ArrayList<>());
    }

    public List<E> getFamilyTree() {
        return familyTree;
    }

    public boolean addMember(E newHuman) {
        if (newHuman==null){
            return false;
        }
        this.familyTree.add(newHuman);
        if (newHuman.getFather()!=null)
        {
            newHuman.getFather().addChild(newHuman);
        }
        if (newHuman.getMother()!=null)
        {
            newHuman.getMother().addChild(newHuman);
        }
        return true;
    }

    public E getByName(String fio)
    {
    for (E human : familyTree) {
        if (human.getName().equals(fio))
        {
            return human;
        }
    }
    return null;
    }
    public String getInfo()
    {
        StringBuilder sb =new StringBuilder();
        sb.append(" Семья состоит из:");
        sb.append("\n");
        for (E human:familyTree) {
            sb.append(human.getInfo());
            sb.append("\n");
        }
        return sb.toString();
    }
    public E find(String name)
    {
        for (E human: familyTree) {
            if(human.getName().equals(name))
            {return human; }
        } return null;
    }
    @Override
    public String toString() {
        return familyTree.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<E>(familyTree);
    }
    public void sortByName(){
        familyTree.sort(new HumanComporatorByName());
    }
    public void sortByChild(){
        familyTree.sort(new HumanComporatorByChild());
    }
}


