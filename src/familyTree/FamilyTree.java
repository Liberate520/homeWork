package familyTree;

import HR.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class FamilyTree implements Serializable, Iterable<Human>{
    private int countPeopleInTree;

    private List<Human> humanList;

    public FamilyTree(){
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public boolean add(Human human){
        if (!humanList.contains(human)){
            humanList.add(human);
            human.setId(countPeopleInTree++);

            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false;
    }

    private void addToParents(Human human){
        for(Human parent: human.getParents()){
            parent.addChild(human);
        }
    }

    private void addToChildren(Human human){
        for (Human child: human.getChildren()){
            child.addParent(human);
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

//    private boolean checkId(int humansId) {
//        return true;
//    }
//
//    private Human getById(int humansId) {
//        return null;
//    }

    public String getByName(String name) {
        List<Human> res = new ArrayList<>();
        for (Human human : humanList) {
            if (human.getName().equals(name)) {
                res.add(human);
            }
        }
        return res.toString();
    }

    private boolean checkId ( int id){
        return id < countPeopleInTree && id >= 0;
    }
    public List<Human> getById (int id){
        if (checkId(id)) {
            for (Human human : humanList) {
                if (human.getId() == id) {
                    return (List<Human>) human;
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
        StringBuilder familytreebase = new StringBuilder();
        familytreebase.append("\n В дереве ");
        familytreebase.append(humanList.size());
        familytreebase.append(" объектов: \n");
        for (Human human : humanList) {
            familytreebase.append(human);
            familytreebase.append("\n");
        }

        return familytreebase.toString();
    }

    @Override
    public Iterator<Human> iterator () {
        return new humanIterator(humanList);
    }
    public void sortByName () {
        humanList.sort(new ComparatorByName());
    }

    public void sortByBirthData () {
        humanList.sort(new ComparatorByBirthDate());
    }
}