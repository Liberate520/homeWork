import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class FamilyTree implements Serializable, Iterable<Human>{
   private List<Human> familyTree;
    public FamilyTree(List<Human> familyTree){
        this.familyTree = familyTree;
    }
    public FamilyTree(){
        this(new ArrayList<>());
    }
    public void addFamilyTree( Human human) {
        if (!familyTree.contains(human)) {
            if (human.getMother() != null) {
                human.getMother().addChild(human);
            }
            if (human.getFather() != null) {
                human.getFather().addChild(human);
            }
            this.familyTree.add(human);
        }
    }
    public Iterator<Human> iterator(){
        return new TreeIterator(familyTree);
    }

    public void sortName(){
        familyTree.sort(new HumanComparatorName());
    }
    public void sortbDay(){
        familyTree.sort(new HumanComparatorBday());
    }

}
