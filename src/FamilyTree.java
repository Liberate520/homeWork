import java.util.ArrayList;
import java.util.Iterator;
import java.io.Serializable;

public class FamilyTree<E extends Human> implements Serializable, Group<E> {
    private ArrayList<E> tree;
    
    public FamilyTree() {
        this.tree = new ArrayList<E>();
    }

    public FamilyTree(ArrayList<E> tree) {
        this.tree = tree;
    }


    public ArrayList<E> getTree() {
        return this.tree;
    }

    public void sortByName() {
        this.tree.sort(new CompareByName());
    }

    public void sortByBirthDate() {
        this.tree.sort(new CompareByBirthDate());
    }

    public void printTree() {
        for (E p : this.tree) {
            System.out.println(p);
        }
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (E e : tree) {
            if (e.getChildrens().size() != 0) {
                result.append(e + "\n");
                if (e.getChildrens() != null) {
                    result.append("\t" + e.stringChildren() + "\n");
                }
            }
        } 
        return result.toString(); 
    }

    @Override
    public Iterator<E> iterator() {
        return this.tree.iterator();
    }

    @Override
    public void add(E h) {
        this.tree.add(h);
    }


    @Override
    public ArrayList<E> getHumansList() {
        return this.tree;
    }

    @Override
    public E getHumanByName(String name) {
        for (E human : tree) {
            if (human.getFirstName() == name) {
                return human;
            }
        }
        return null;
    }
}