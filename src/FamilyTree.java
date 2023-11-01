import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human>{
    private List<Human> familyTreeList = new ArrayList<>();

    public void addHuman(Human human){
        familyTreeList.add(human);
    }

    public void getAllHuman(){
        for (Human human: familyTreeList){
            System.out.println(human.allInfo());
        }
    }

    public void getHuman(int id){
        for (Human human: familyTreeList){
            if(human.id == id){
                System.out.println(human.allInfo());
            }
        }
    }

    public void sortByName(){
        familyTreeList.sort(new TreeComparatorByName());
    }

    public void sortByBirthDay(){
        familyTreeList.sort(new TreeComparatorByBirthDay());
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(familyTreeList);
    }
}
