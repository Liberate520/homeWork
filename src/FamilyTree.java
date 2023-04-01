import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class FamilyTree {
    private HashMap<Parent, HashSet<Children>> tree;

    FamilyTree() {
        this.tree = new HashMap<>();
    }

    public void put(Parent m, Parent f, Children child) {
        put(f, child);
        put(m, child);
    }

    
    public void put(Human m, Human f, Human child) {
        Parent p1 = new Parent(m);
        Parent p2 = new Parent(f);
        put(p1, p2, new Children(child, p1, p2));
    }
    
    public void put(Parent p, Children child) {
        p.addChildrens(child);
        child.addParent(p);
        this.tree.put(p, p.getChildrens());
    }

    public String getParentChild(Human p) {
        StringBuilder result = new StringBuilder();
        result.append(p.toString());
        HashSet<Children> child = new HashSet<>();


        return result.toString();
    }

    public String getChildren(Parent p) {
        ArrayList<Children> child = new ArrayList<>();
        child.addAll(this.tree.get(p));
        return child.toString(); 
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (Parent key : this.tree.keySet()) {
            result.append(key.toString() + " - ");
            for (Children child : this.tree.get(key)) result.append(child.toString() + ", ");
            result.deleteCharAt(result.length() - 2);
            result.append("\n");
        }
        result.deleteCharAt(result.length() - 1);


        return result.toString();
    }








    
    // public void addChildren(Human child, Parent mather, Parent father) {
    //     Children children = new Children(child, mather, father);
    //     this.childrens.add(children);
    //     father.addChildrens(children);
    //     mather.addChildrens(children);
    // }

    // public void addChildren(Human child, Human m, Human f) {
    //     Parent mather = new Parent(m);
    //     Parent father = new Parent(f); 
    //     Children children = new Children(child, mather, father);
    //     this.childrens.add(children);
    //     father.addChildrens(children);
    //     mather.addChildrens(children);
    //     addParent(father);
    //     addParent(mather);
    // }

    


}
