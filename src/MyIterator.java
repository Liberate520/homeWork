import java.util.Iterator;
import java.util.List;

public class MyIterator implements Iterator<Cat> {

    private List<Cat> cats;
    private int index = 0;

    public MyIterator(List<Cat> cats) {
        this.cats = cats;
    }

    @Override
    public boolean hasNext() {
        return index < cats.size();
    }

    @Override
    public Cat next() {
        return cats.get(index++);
    } 
    
}
