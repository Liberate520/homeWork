import java.util.ArrayList;
import java.util.List;

public class Tree {
    List<Human> tree;
    
    public Tree(List<Human> tree){
        this.tree = tree;
    }

    public Tree(){
        this(new ArrayList<>());
    }

    public void addFamilyTree( Human human){
                this.tree.add(human);
    }

}
