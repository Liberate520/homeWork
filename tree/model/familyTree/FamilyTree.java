package model.familyTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import model.essences.Creature;
import model.handlers.Saveable;

public class FamilyTree<E extends Creature<E>> implements Saveable, Iterable<E> {
    private String familyName;
    private ArrayList<E> creatureList;

    public FamilyTree() {
        this.creatureList = new ArrayList<>();
    }

    public String getFamilyName() {
        return familyName;
    }

    @Override
    public Iterator<E> iterator() {
        return creatureList.iterator();
    }

    // @Override
    // public String getInfo() {
    // return "";
    // }

    public ArrayList<E> getCreatureList() {
        return this.creatureList;
    }

    /**
     * Добавляет человека в дерево
     * 
     * @param human
     * @return
     */
    public boolean addHuman(E human) {
        try {
            creatureList.add(human);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 
     * @param childFirstName
     * @param childLastName
     * @param parentFirstName
     * @param parentLastName
     * @return
     */
    public boolean validForChild(String childFirstName, String childLastName, String parentFirstName,
            String parentLastName) {
        if (creatureList.size() <= 1)
            return false;
        return true;
    }

    /**
     * функция getDescendants ищет потомков для
     * указанного персонажа
     * 
     * @param Human - получает объект персонажа
     * @return - возвращает список потомков
     */
    public HashSet<E> getDescendants(E human) {
        HashSet<E> descendants = new HashSet<>();
        for (E child : human.getChildren()) {
            descendants.add(child);
            descendants.addAll(getDescendants(child));
        }
        return descendants;
    }

    /**
     * функция getAncestors ищет предков для
     * указанного персонажа
     * 
     * @param Human - получает объект персонажа
     * @return - возвращает список предков
     */
    public HashSet<E> getAncestors(E human) {
        HashSet<E> ancestors = new HashSet<>();
        for (E parent : human.getParents()) {
            ancestors.add(parent);
            ancestors.addAll(getAncestors(parent));
        }
        return ancestors;
    }

    /**
     * функция getRelatives ищет родственные связи для
     * указанного персонажа
     * 
     * @param Human - получает объект персонажа
     * @return - возвращает список связей
     */
    public HashSet<E> getRelatives(E human) {
        HashSet<E> relatives = new HashSet<>();
        relatives.addAll(getAncestors(human));
        relatives.addAll(getDescendants(human));
        return relatives;
    }

    public E getHumanByNames(String firstName, String lastName) {
        for (E human : getCreatureList()) {
            if (human.getFirstName().equals(firstName) && human.getLastName().equals(lastName))
                return human;
        }
        return null;
    }

}
