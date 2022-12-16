package part2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CatsFlock implements Iterable<Cats>{
    List<Cats> catsList;

    public CatsFlock() {
        catsList = new ArrayList<>();
    }

    public void addCats(Cats cat) {
        catsList.add(cat);
    }
    public Cats getCat(int id) {
        return catsList.get(id);
    }

    @Override
    public Iterator<Cats> iterator() {
        return new CatsIterator();
    }

    class CatsIterator implements Iterator<Cats> {
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < catsList.size();
        }
        @Override
        public Cats next() {
            return catsList.get(index++);
        }
    }
}