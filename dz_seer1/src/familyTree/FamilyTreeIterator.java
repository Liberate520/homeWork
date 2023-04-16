package familyTree;

import human.Human;

import java.util.Iterator;
import java.util.Stack;

public class FamilyTreeIterator implements Iterator<Human> {
    private Stack<Human> stack;

    public  FamilyTreeIterator(Human root){
        stack = new Stack<>();
        if(root != null){
            stack.push(root);
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public Human next() {
        Human node = stack.pop();
        if(node.getChildren() != null){
            for (Human child: node.getChildren() ) {
                stack.push(child);
            }
        }
        return node;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
