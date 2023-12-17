package FamilyTree.model.FT;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class FamTree<T extends commonParam<T>> implements Serializable, Iterable<T> {
    private int peopleCounter;
    private List<T> humanList;

    public FamTree(){
        this(new ArrayList<>());
    }
    public FamTree(List<T> humanList) {
        this.humanList = humanList;
    }
    public boolean add(T human){
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

    private void addToParents(T human){
        for(T parent: human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(T human){
        for (T child: human.getChildren()){
            child.addParent(human);
        }
    }

    public List<T> getSiblings(int id){
        T human = (T) getById(id);
        if (human == null){
            return null;
        }
        List<T> result = new ArrayList<>();
        for (T parent: human.getParents()){
            for (T child: parent.getChildren()){
                if (!child.equals(human)){
                    result.add(child);
                }
            }
        }
        return result;
    }

    public List<T> getByName(String name) {
        List<T> result = new ArrayList<>();
        for (T human : humanList) {
            if (human.getName().equals(name)) {
                result.add(human);
            }
        }
        return result;     //.toString();                   // ?.toString
    }
    private boolean checkId ( int id){
        return id < peopleCounter && id >= 0;
    }
    public T getById (int id){
        for (T human : humanList) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }


    public boolean setWedding(T human1, T human2){
        if(human1.getSpouse() == null && human2.getSpouse() == null){
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean remove(int peopleCounter){
        if (checkId(peopleCounter)){
            T e;
            T human = getById(peopleCounter);
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
        for (T human : humanList) {
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
    public Iterator<T> iterator() {
        return new HumanIterator(humanList);
    }
}
