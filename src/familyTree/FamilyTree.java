package familyTree;

import familyTree.comparators.Group;
import human.Human;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


//public class FamilyTree<E extends Human> implements Group<E>, Serializable, Iterable<E>  {
public class FamilyTree<E extends Group<E>> implements Group<E>, Serializable, Iterable<E>  {

    // public String name;
    private E root;
    private List<E> humanList;
    private List<E> petList;

    private List<E> childList;

    public FamilyTree() {
        this.humanList = new ArrayList<>();
        this.petList = new ArrayList<>();
    }
    public FamilyTree(E root) {
        this.root = root;
    }
    public E getRoot() {
        return root;
    }

    @Override
    public List<E> getPetList() {
        return petList;
    }

    @Override
    public String getName() {
        if (root != null) {
            return root.getName();
        }
        return null;
    }
    @Override
    public String getSurname() {
        if (root != null) {
            return root.getSurname();
        }
        return null;
    }
    @Override
    public List<E> getHumanList() {
        return humanList;
    }

    public void setRoot(E root) {
        this.root = root;
    }

    public E getByName(String name) {
        for (E human :
                humanList) {
            if (human.getName().equals(name))
                return human;
        }
        return null;
    }
    public E getBySurname(String surname) {
        for (E human :
                humanList) {
            if (human.getSurname().equals(surname))
                return human;
        }
        return null;
    }

    public void addHuman(E human) {
        humanList.add(human);
    }
    public void addPet(E pet) {
        petList.add(pet);
    }

    public boolean add(E human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            if (human.getFather() != null) {
                human.getFather().addChild(human);
            }
            if (human.getMother() != null) {
                human.getMother().addChild(human);
            }
            return true;
        }
        return false;
    }

    public String getInfo() {
        StringBuilder tree = new StringBuilder();
        tree.append("В дереве ").append(humanList.size())
                .append(" объектов").append(" \n");
        for (E human: this.humanList) {
            tree.append(human.getInfo()).append("\n");
        }
        return tree.toString();
    }

    public E getFather() {
        return root.getFather();
    }

    @Override
    public E getMother() {
        return root.getMother();
    }

    @Override
    public void addChild(E child) {
         childList.add(child);

    }
    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(humanList);
    }


}
