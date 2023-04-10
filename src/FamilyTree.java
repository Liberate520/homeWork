import java.util.ArrayList;
import java.io.Serializable;

public class FamilyTree implements Serializable {
    private ArrayList<Human> tree;
    
    public FamilyTree() {
        this.tree = new ArrayList<Human>();
    }

    public FamilyTree(ArrayList<Human> tree) {
        this.tree = tree;
    }

    public void add(Human h) {
        this.tree.add(h);
    }

    public ArrayList<Human> getTree() {
        return this.tree;
    }

    public FamilyTree sortByName() {
        ArrayList<Human> res = new ArrayList<Human>();
        res.addAll(this.tree);
        res.sort(new CompareByName());
        
        return new FamilyTree(res);
    }

    public FamilyTree sortByBirthDate() {
        ArrayList<Human> res = new ArrayList<Human>();
        res.addAll(this.tree);
        res.sort(new CompareByBirthDate());
        
        return new FamilyTree(res);
    }

    public void printTree() {
        for (Human p : this.tree) {
            System.out.println(p);
        }
    }



    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Human human : tree) {
            if (human.getChildrens().size() != 0) {
                result.append(human + "\n");
                if (human.getChildrens() != null) {
                    result.append("\t" + human.stringChildren() + "\n");
                }
            }
        } 
        return result.toString(); 
    }
}