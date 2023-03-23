package model;

import java.util.Iterator;
import java.util.List;

public class NotesIterator <T> implements Iterator<T> {
    private int index;
    private List<T> notes;
    public  NotesIterator(List<T> notes){
        this.notes=notes;
    }


    @Override
    public boolean hasNext() {
        return notes.size()>index;
    }

    @Override
    public T next() {
        return notes.get(index++);
    }
}
