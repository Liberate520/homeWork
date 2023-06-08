import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends TreeItem<E>> implements Serializable, Tree<E> {
    private List<E> humanList;

    public FamilyTree(){
        humanList = new ArrayList<>();
    }

    public void addHuman(E human){
        humanList.add(human);
    }


    public E getByName(String name){
        for(E item : humanList){
            if(item.getName().equals(name)){
                return item;
            }
        }
        return null;
    }



    public List<E> findBrothers(E humanForSearch){
        List<E> brothersList = new ArrayList<>();
        List<E> tempList = new ArrayList<>();
        if(humanForSearch.getFather() != null) {tempList = humanForSearch.getFather().getChildren();}
        else if (humanForSearch.getMother() != null) {tempList = humanForSearch.getMother().getChildren();}

        for(E item : tempList){
            if (item.getGender() == Gender.MALE && !item.getName().equals(humanForSearch.getName())){
                brothersList.add(item);
            }
        }

        return brothersList;
    }

    public String printHumanList(){
        String printer = "Family tree contains " + humanList.size() + " entities:" + "\n";
        for(E item : humanList){
            printer += item.toString() + "\n";
        }
        return printer;
    }

    public List<E> getHumanList() {
        return humanList;
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(humanList);
    }

    public void sortByName(){
        humanList.sort(new HumanComparatorByName<>());
    }

    public void sortByBirthDate(){
        humanList.sort(new HumanComparatorByBirthDate<>());
    }

}
