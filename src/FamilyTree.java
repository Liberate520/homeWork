import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    List<Human> familyTree;

    public FamilyTree(List<Human> familyTree) {
        this.familyTree = familyTree;
    }

    public FamilyTree() {
        this.familyTree = new ArrayList<>();
    }

    public void add(Human human){
        this.familyTree.add(human);
    }

    public List<Human> search(String lastName){
        List<Human> searchTemp = new ArrayList<>();
        for (Human item: familyTree) {
            if(item.getLastName().equals(lastName)) searchTemp.add(item);
        }
        return searchTemp;
    }

    public String toString() {
        for (Human item : familyTree) {
            System.out.println(item);
        }
        return " ";
    }

}
