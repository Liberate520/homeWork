package service.dataBase;

import service.classes.Person;

import java.util.ArrayList;
import java.util.Iterator;

public class DataBaseIterator implements Iterator<Person> {
    int index;
    ArrayList<Person> db;

public DataBaseIterator(ArrayList<Person> db){
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
