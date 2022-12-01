package dataBase;

import classes.Person;

import java.util.ArrayList;
import java.util.Iterator;

public class ParentIterator implements Iterator<Person> {
    int index;
    ArrayList<Person> db;

public ParentIterator(ArrayList<Person> db){
    this.db = db;
    this.index = 0;
}
    @Override
    public boolean hasNext() {
        return index < this.db.size();
    }

    @Override
    public Person next() {
        return this.db.get(index++);
    }
}
