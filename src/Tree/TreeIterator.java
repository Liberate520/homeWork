package Tree;

import People.Person;

import java.util.Iterator;
import java.util.List;

public class TreeIterator implements Iterator<Person> {
    private int index;
    private List<Person> targariens;

    public TreeIterator(List<Person> targariens){
        this.targariens = targariens;
    }

    @Override
    public boolean hasNext(){
        return index < targariens.size();
    }

    @Override
    public Person next() {
        return targariens.get(index++);
    }
}
