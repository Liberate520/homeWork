package FamilyTree.family_tree;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import FamilyTree.KindOfAnimal.Gender;
import FamilyTree.KindOfAnimal.Human;
    // Класс, представляющий генеалогическое древо
public class FamilyTree<T extends Human> implements Serializable , Iterable<T>{
    private long humansId;
    private List<T> humanList;

    public FamilyTree(){ 
        this(new ArrayList<>()); 
    }

    public FamilyTree(List<T> humanList) { 
        this.humanList = humanList;
    }

    public boolean add(T human) {
        if (human == null) {
            return false;
            }
        if (!humanList.contains(human)){
            humanList.add (human);
            human. setId (humansId++);


            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false;
    }
    public T getById(long id) {
        if (!checkId(id)) {
            return null;
        }
        for (Human human: humanList) {
        if (human.getId() == id) {
            return (T) human;
            }
        }
        return null;
    }
    public List<T> getSiblings(int id) {
        T human = getById(id);
        if (human == null) {
            return null;
        }
        List<T> res = new ArrayList<>();
        for (Human parent: human.getParents()){
            for (Human child: parent.getChildren()){
                if (!child.equals(human) && !res.contains(child)){
                    res. add ((T) child);
                }
            }
        }
        return res;
    }

    public List<T> getByName(String name) {
        List<T> res = new ArrayList<>();
        for (Human human : humanList) {
            if (human. getName().equals(name)) {
                res. add ((T) human);
            }   
        }
        return res;
    }

    public boolean setWedding(Long humanId1, Long humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            T human1 = getById(humanId1);
            T human2 = getById(humanId2);
            return setWedding (human1, human2);
        }
        return false;
    }

    public boolean setWedding(T human1, T human2) {
        if(human1. getSpouse() == null && human2.getSpouse() == null) {
            human1. setSpouse (human2) ; 
            human2. setSpouse (human1) ; return true;
            }
        else {
            return false;
        }
    }

    public boolean setDivorce(long humanId1, Long humanId2) {
        if( checkId(humanId1) && checkId(humanId2)) {
            T human1 = getById(humanId1);
            T human2 = getById(humanId2);
            return setDivorce(human1, human2);
        }
        return false;
    }
    public boolean setDivorce(T human1, T human2) {
        if (human1.getSpouse() != null && human2.getSpouse() != null) {
            human1. setSpouse (null); 
            human2. setSpouse (null);
            return true;
        }
        else {
            return false;
        }
    }
    public boolean remove(long humanId) {
        if (checkId(humanId)) {
            T human = getById(humanId);
            return humanList.remove(human);
        }
        return false;
    }

    private void addToParents(T human) {
        for (Human parent: human.getParents()){
            parent.addChild(human);
        }
    }

    private void addToChildren(T human) {
        for (Human child: human.getChildren()) {
            child.addParent(human);
        }
    }

    private boolean checkId(long id) { 
        return id < humansId && id >= 0;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append ("В дереве ");
        sb.append (humanList.size());
        sb.append ("объектов: \n");
        for (Human human : humanList) {
            sb. append (human);
            sb. append ("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() { 
        return getInfo(); 
    }

    public Gender getGender() {
        return getGender();
    }


    public void addFamilyMember(T parent, T child) {
        parent.addChild(child);
    }


    public List<T> getChildrenOfHuman(Human human) {
        return (List<T>) human.getChildren();
    }


    @Override
    public Iterator<T> iterator() {
        return  FamilyTreeIterator(humanList);
    }
    private Iterator<T> FamilyTreeIterator(List<T> humanList2) {
        return null;
    }

    public void sortByName() {
        humanList.sort((Comparator<? super Human>) Comparator.comparing(T::getName));
    }

    public void sortByBirthDate() {
        humanList.sort((Comparator<? super Human>) Comparator.comparing(T::getBirthDate));
    }
    

}








