import java.io.Serializable;
import java.util.*;

public class FamilyTree <E extends Item> implements Serializable, Iterable<E> {
     public List<E> familyList;

    public FamilyTree() {
        familyList = new ArrayList<>();
    }

    public void familyAdd(E name){
        familyList.add(name);
    }

    public void setFamilyList(List<E> familyList) {
        this.familyList = familyList;
    }

    public List<E> getFamilyList() {
        return familyList;
    }

    public void familyInfo(){
        System.out.println(familyList + "\n");
    }

    public  void sortByName(){
        familyList.sort(new FamilyComparatorByName<>());
    }

    public  void sortByAge(){
        familyList.sort(new FamilyComparatorByAge<>());
    }


    @Override
    public Iterator<E> iterator() {
        return new FamilyIterator<>(familyList);
    }

}
