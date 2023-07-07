package homeWork_OOP_family_tree.comparatorAndIterator;

import java.util.Iterator;
import java.util.List;

import homeWork_OOP_family_tree.infoHuman.Node;

public class FamilyIterator implements Iterable<Node>, Iterator<Node>{
       int index;
    List<Node> familyHuman;

    public FamilyIterator(List<Node> familyHuman) {
        this.familyHuman = familyHuman;
    }


    public boolean hasNext() {
        return familyHuman.size() > index;
    }


    public Node next() {
        return familyHuman.get(index++);
    }


    @Override
    public Iterator<Node> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }
}
