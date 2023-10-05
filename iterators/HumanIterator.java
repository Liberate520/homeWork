package iterators;

import java.util.Iterator;
import java.util.List;

//import members.Human;
//import members.Dog;

public class HumanIterator<E> implements Iterator<E>{
    private int index;
    private List<E> humanList;
    public HumanIterator(List<E> humanList){
        this.humanList = humanList;
    }
    @Override
    public boolean hasNext(){
        return humanList.size() > index;
    }

    @Override
    public E next(){
        return humanList.get(index++);
    }
}
