import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayGroup implements Iterable<ArrayNumbers> {
    private List<ArrayNumbers> array;

    public ArrayGroup(List<ArrayNumbers> array) {
        this.array = array;
    }

    public ArrayGroup() {
        array = new ArrayList<>();
    }

    public List<ArrayNumbers> getArray() {
        return array;
    }

    public void setArray(List<ArrayNumbers> array) {
        this.array = array;
    }

    public void addNumbers(Integer numbers)
    {
        ArrayNumbers numbers1 = new ArrayNumbers(numbers);
        array.add(numbers1);
    }
    public void sortBy(){
        array.sort(new Sort());
    }
    @Override
    public Iterator<ArrayNumbers> iterator() {
        return new ArrayGroupIterator(array);
    }


}
