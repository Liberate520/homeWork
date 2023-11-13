import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends GroupItem> implements Serializable, Iterable<E>{
    private List<E> familyTreeList = new ArrayList<>();

    public void addHuman(E human){
        familyTreeList.add(human);
    }

    public void getAllHuman(){
        for (E human: familyTreeList){
            System.out.println(human.allInfo());
        }
    }

    public void getHuman(int id){
        for (E human: familyTreeList){
            if(human.getId() == id){
                System.out.println(human.allInfo());
            }
        }
    }

    public void sortByName(){
        familyTreeList.sort(new TreeComparatorByName<>());
    }

    public void sortByBirthDay(){
        familyTreeList.sort(new TreeComparatorByBirthDay<>());
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(familyTreeList);
    }
}
