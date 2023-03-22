package Notebook.Core.Infrastructure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Notebook.Core.Models.Recording;

public class Notebook implements Iterable <Recording> {

    List<Recording> records;
    private int size;

    public Notebook() {
        records = new ArrayList<>();
        size = 0;
    }

    public void add(Recording element) {
        records.add(element);
    }

    public void printArr() {
        for (Recording recording : records) {
            recording.printRecord();
        }
    }

    public Iterator<Recording> iterator() {

        Iterator<Recording> it = new Iterator<Recording>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < records.size();
            }

            @Override
            public Recording next() {
                return records.get(index++);
            }
        };
        return it;
    }

    public int size() {
        return records.size();
    }

    public Recording get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("The index is invalid!");
            return null;
        }
        return records.get(index);
    }

    public void remove(int index) {
        records.remove(index);
        size--;
    }

    public void set(int index, Recording obj) {
        records.set(index, obj);
    }

    public List<Recording> getRecords() {
        return records;
    }

    public int getSize() {
        return size;
    }

}
