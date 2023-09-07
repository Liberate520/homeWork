package Tree;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import Human.Human;
import Human.comparators.HumanComparatorByAge;
import Human.comparators.HumanComparatorByName;

public class Tree<E extends TreeCommon<E>> implements Serializable, Iterable<E>{
    private List<E> humanList;
    private int id;
    
    public Tree(){
        this(new ArrayList<>());
    }

    private Tree(List<E> tree){
        this.humanList = tree;
    }

    public boolean add(E human){
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)){
            humanList.add(human);
            human.setId(id++);
            addChildren(human);
            addParents(human);
            return true;
        }
        return false;
    }
    private void addParents(E human){
        for (E parent: human.getParents()){
            parent.addChild(human);
        }
    }
    private void addChildren(E human){
        for (E child: human.getChildren()){
            child.addParent(human);
        }
    }

    public void addFamilyTree(E human){
        this.humanList.add(human);
    }
    public String getFamilyTreeInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список людей в семейном древе:\n");

        for (E human: humanList){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    @Override
    public Iterator<E> iterator() { return new HumanIterator<E>(humanList);}
    public void sortByName() {
        humanList.sort(new HumanComparatorByName<>());
    }
    public void sortByAge() {
        humanList.sort(new HumanComparatorByAge<>());
    }


}
