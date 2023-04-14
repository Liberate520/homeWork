<<<<<<< HEAD
package scr;
=======
>>>>>>> 5f47d820a5cdbe61b715ea2f7384eb7635e321f4

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