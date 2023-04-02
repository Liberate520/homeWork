import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human>{
    private List<Human> familyTree = new ArrayList<Human>();
    public FamilyTree(List<Human> familyTree) {
        this.familyTree = familyTree;
    }
    public  FamilyTree()
    {
        this(new ArrayList<>());
    }

    public List<Human> getFamilyTree() {
        return familyTree;
    }

    public boolean addMember(Human newHuman) {
        if (newHuman==null){
            return false;
        }
        this.familyTree.add(newHuman);
        if (newHuman.getFather()!=null)
        {
            newHuman.getFather().addChild(newHuman);
        }
        if (newHuman.getMother()!=null)
        {
            newHuman.getMother().addChild(newHuman);
        }
        return true;
    }

    public Human getByName(String fio)
    {
    for (Human human : familyTree) {
        if (human.getName().equals(fio))
        {
            return human;
        }
    }
    return null;
    }
    @Override
    public String toString() {
        return familyTree.toString();
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(familyTree);
    }
    public void sortByName(){
        familyTree.sort(new HumanComporatorByName());
    }

}


