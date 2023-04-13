import java.util.ArrayList;
import java.util.Iterator;
import java.io.Serializable;

public class FamilyTree implements Serializable, Group {
    private ArrayList<Human> tree;
    
    public FamilyTree() {
        this.tree = new ArrayList<Human>();
    }

    public FamilyTree(ArrayList<Human> tree) {
        this.tree = tree;
    }


    public ArrayList<Human> getTree() {
        return this.tree;
    }

    public void sortByName() {
        this.tree.sort(new CompareByName());
    }

    public void sortByBirthDate() {
        this.tree.sort(new CompareByBirthDate());
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

    @Override
    public Iterator<Human> iterator() {
        return this.tree.iterator();
    }

    @Override
    public void addHuman(Human h) {
        this.tree.add(h);
    }


    @Override
    public ArrayList<Human> getHumansList() {
        return this.tree;
    }

    @Override
    public Human getHumanByName(String name) {
        for (Human human : tree) {
            if (human.getFirstName() == name) {
                return human;
            }
        }
        return null;
    }
}