package OOP_HW3;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class CustomCollection <T> implements Iterable, Iterator<T>{

    private List<T> list;
    int i = 0;//index

    public CustomCollection() {
        this.list = new ArrayList<>();
    }

    public void add (T item){
        list.add(item);
    }
    public T get(int i){
        return list.get(i);
    }

    @Override
    public boolean hasNext() {
        return i < list.size();
    }


    @Override
    public T next() {
        return list.get(i++);
    }


    @Override
    public Iterator iterator() {
        return this;
    }

}
