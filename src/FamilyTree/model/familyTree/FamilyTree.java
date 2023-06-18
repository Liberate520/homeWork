package FamilyTree.model.familyTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class FamilyTree<T extends TreeItem<T>> implements Serializable, Iterable<T> {
    private ArrayList<T> humanList;
    public FamilyTree() {
        this(new ArrayList<>());
    }
    public FamilyTree(ArrayList<T> humanList){
        this.humanList = humanList;
    }
    public boolean addMember(T human) {
        if (human == null) {
            return false;
        }
        if(!humanList.contains(human)){
            humanList.add(human);
            if (human.getFather() != null){
                human.getFather().addChild(human);
            }
            if (human.getMother() != null){
                human.getMother().addChild(human);
            }
            return true;
        }
        return false;
    }
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В дерерве ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (T human: humanList){
            sb.append(human.getInfo());
            sb.append("\n");
        }
        return sb.toString();
    }

    public T getByName(String name){
        for (T human: humanList){
            if (human.getName().equals(name)){
                return human;
            }
        }
        return null;
    }
    public void sortByName(){
        humanList.sort(new NameComparator<>());
    }
    public void sortByAge(){
        humanList.sort(new AgeComparator<>());
    }
    public void sortByChilds(){
        humanList.sort(new ChildComparator<>());
    }
    @Override
    public Iterator<T> iterator() {
        return new TreeIterator<>(humanList);
    }
}
