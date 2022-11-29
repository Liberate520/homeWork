package dataBase;

import classes.Parent;

import java.util.ArrayList;
import java.util.Iterator;

public class ParentIterator implements Iterator<Parent> {
    int index;
    ArrayList<Parent> db;

public ParentIterator(ArrayList<Parent> db){
    this.db = db;
    this.index = 0;
}
    @Override
    public boolean hasNext() {
        return index < this.db.size();
    }

    @Override
    public Parent next() {
        return this.db.get(index++);
    }
}
