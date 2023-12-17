package FamilyTree.FT;

import FamilyTree.HR.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class FamTree implements Serializable, Iterable<Human> {   //...Tree<E extends commonParam<E>>...
    private int peopleCounter;
    private List<Human> humanList;

    public FamTree(){
        this(new ArrayList<>());
    }
    public FamTree(List<Human> humanList) {
        this.humanList = humanList;
    }
    public boolean add(Human human){
//        if(human ==null){                     // можно убрать
//            return false;                     //
//        }
        if (!humanList.contains(human)){
            humanList.add(human);
            human.setId(peopleCounter++);

            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false;
    }

    private void addToParents(Human human){
        for(Human parent: human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(Human human){
        for (Human child: human.getChildren()){
            child.addParent(human);
        }
    }

    public List<Human> getSiblings(int id){
        Human human = getById(id);
        if (human == null){
            return null;
        }
        List<Human> result = new ArrayList<>();
        for (Human parent: human.getParents()){
            for (Human child: parent.getChildren()){
                if (!child.equals(human)){
                    result.add(child);
                }
            }
        }
        return result;
    }

    public String getByName(String name) {
        List<Human> result = new ArrayList<>();
        for (Human human : humanList) {
            if (human.getName().equals(name)) {
                result.add(human);
            }
        }
        return result.toString();                   // ?.toString
    }
    private boolean checkId ( int id){
        return id < peopleCounter && id >= 0;
    }
    public Human getById (int id){
        for (Human human : humanList) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }


    public boolean setWedding(long peopleCounter1, long peopleCounter2){
        if(checkId((int)peopleCounter1) && checkId((int)peopleCounter2)){
            Human human1 = getById((int)peopleCounter1);
            Human human2 = getById((int)peopleCounter2);
            return true;
        }
        else {
            return false;
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

    public boolean remove(int countPeopleInTree){
        if (checkId(countPeopleInTree)){
//            Human e;
            Human human = (Human) getById(countPeopleInTree);
            return humanList.remove(human);
        }
        return false;
    }


    @Override
    public String toString () {
        return getInfo();
    }
    public String getInfo () {
        StringBuilder ftbase = new StringBuilder();
        ftbase.append("\n В дереве ");
        ftbase.append(humanList.size());
        ftbase.append(" объектов: \n");
        for (Human human : humanList) {
            ftbase.append(human);
            ftbase.append("\n");
        }
        return ftbase.toString();
    }



    public void sortByName(){
        humanList.sort(new ComparatorByName());
    }
    public void sortByBirthDate(){
        humanList.sort(new ComparatorByBirthDate());
    }
    public void sortByBirthData () {
        humanList.sort(new ComparatorByAge());
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humanList);
    }
}
