import java.util.Iterator;
import java.util.List;

public class ArrayGroupIterator implements Iterator<ArrayNumbers> {

    private int index;
    private List<ArrayNumbers> arrayNumbers;

    public ArrayGroupIterator(List<ArrayNumbers> arrayNumbers) {
        this.arrayNumbers = arrayNumbers;
    }

    @Override
    public boolean hasNext() {
        return index < arrayNumbers.size();
    }

    @Override
    public ArrayNumbers next() {
        return arrayNumbers.get(index++);
    }
}
