package model.familyTree;

import model.HR.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class FamilyTree<E extends commonParam> implements Serializable, Iterable<E>{
    private int countPeopleInTree;

    private List<E> humanList;

    public FamilyTree(){
        this(new ArrayList<>());
    }

    public FamilyTree(List<E> humanList) {
        this.humanList = humanList;
    }

    public boolean add(E human){
        if (!humanList.contains(human)){
            humanList.add((E) human);
            human.setId(countPeopleInTree++);

            addToParents((E) human);
            addToChildren((E) human);

            return true;
        }
        return false;
    }

    private void addToParents(E human){
        for(E parent: human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(E human){
        for (Human child: human.getChildren()){
            child.addParent((Human) human);
        }
    }

    public boolean setWedding(Human human1, Human human2){
        if(human1.getSpouse() == null && human2.getSpouse() == null){
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean remove(int humansId){
        if (checkId(humansId)){
//            Human e;
            Human e = (Human) getById(humansId);
            return humanList.remove(e);
        }
        return false;
    }

    private boolean checkId(long id){
        if (id >= countPeopleInTree || id < 0){
            return false;
        }
        for (E human: humanList){
            if (human.getId() == id){
                return true;
            }
        }
        return false;
    }
//
    public E getById(long id){
        for (E human: humanList){
            if (human.getId() == id){
                return human;
            }
        }
        return null;
    }

    public List<E> getByName(String name) {
        List<E> result = new ArrayList<>();
        for (E human : humanList) {
            if (human.getName().equals(name)) {
                result.add(human);
            }
        }
        return result;
    }

    private boolean checkId ( int id){
        return id < countPeopleInTree && id >= 0;
    }
    public List<E> getById (int id){
        if (checkId(id)) {
            for (E human : humanList) {
                if (human.getId() == id) {
                    return (List<E>) human;
                }
            }
        }
        return null;
    }


    @Override
    public String toString () {

        return getInfo();
    }
    public String getInfo () {
        StringBuilder famtreebase = new StringBuilder();
        famtreebase.append("\n Семья состоит из ");
        famtreebase.append(humanList.size());
        famtreebase.append(" человек: \n");
        for (E human : humanList) {
            famtreebase.append(human);
            famtreebase.append("\n");
        }

        return famtreebase.toString();
    }

    @Override
    public Iterator<E> iterator () {
        return new humanIterator<>(humanList);}

    public void sortByName () {

        humanList.sort(new ComparatorByName<>());
    }

    public void sortByBirthData () {

        humanList.sort(new ComparatorByBirthDate<>());
    }

    public void addHuman(Human human) {

    }
}