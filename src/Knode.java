import java.util.ArrayList;
import java.util.Iterator;

public class Knode<T extends Node> implements Tree<T>, Iterable<T>
{
    private T value;
    private  ArrayList<T> allTree = new ArrayList<>();
    

    @Override
    public void addAll(T t) 
    {
        allTree.add(t);
    
    }
    @Override
    public String toString() {
        return allTree.toString();
    }
    @Override
    public Iterator<T> iterator(){
        return new HumanIterator<T>(allTree);
    }
}
