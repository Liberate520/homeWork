package FamilyTree.family_tree;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import FamilyTree.human.Gender;
import FamilyTree.human.Human;
    // Класс, представляющий генеалогическое древо
public class FamilyTree implements Serializable , Iterable<Human>{
    private long humansId;
    private List<Human> humanList;

    public FamilyTree(){ 
        this(new ArrayList<>()); 
    }

    public FamilyTree(List<Human> humanList) { 
        this.humanList = humanList;
    }

    public boolean add(Human human) {
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
    public Human getById(long id) {
        if (!checkId(id)) {
            return null;
        }
        for (Human human: humanList) {
        if (human.getId() == id) {
            return human;
            }
        }
        return null;
    }
    public List<Human> getSiblings(int id) {
        Human human = getById(id);
        if (human == null) {
            return null;
        }
        List<Human> res = new ArrayList<>();
        for (Human parent: human.getParents()){
            for (Human child: parent.getChildren()){
                if (!child.equals(human) && !res.contains(child)){
                    res. add (child);
                }
            }
        }
        return res;
    }

    public List<Human> getByName(String name) {
        List<Human> res = new ArrayList<>();
        for (Human human : humanList) {
            if (human. getName().equals(name)) {
                res. add (human);
            }   
        }
        return res;
    }

    public boolean setWedding(Long humanId1, Long humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            Human human1 = getById(humanId1);
            Human human2 = getById(humanId2);
            return setWedding (human1, human2);
        }
        return false;
    }

    public boolean setWedding(Human human1, Human human2) {
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
            Human human1 = getById(humanId1);
            Human human2 = getById(humanId2);
            return setDivorce(human1, human2);
        }
        return false;
    }
    public boolean setDivorce(Human human1, Human human2) {
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
            Human human = getById(humanId);
            return humanList.remove(human);
        }
        return false;
    }

    private void addToParents(Human human) {
        for (Human parent: human.getParents()){
            parent.addChild(human);
        }
    }

    private void addToChildren(Human human) {
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


    public void addFamilyMember(Human parent, Human child) {
        parent.addChild(child);
    }


    public List<Human> getChildrenOfHuman(Human human) {
        return human.getChildren();
    }


    @Override
    public Iterator<Human> iterator() {
        List<Human> humanList = new ArrayList<>();
        return new FamilyTreeIterator(humanList);
    }

    public void sortByName() {
        humanList.sort(Comparator.comparing(Human::getName));
    }

    public void sortByBirthDate() {
        humanList.sort(Comparator.comparing(Human::getBirthDate));
    }
    

}








