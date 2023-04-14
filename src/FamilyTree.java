
import java.util.ArrayList;
import java.util.List;

public class FamilyTree {

    private List<Human> tree;

    public FamilyTree(List<Human> tree){
        this.tree = tree;
    }

    public FamilyTree(){
        this(new ArrayList<>());
    }

    public void addHuman(Human human) {
        tree.add(human);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return tree.toString();
    }
    
}