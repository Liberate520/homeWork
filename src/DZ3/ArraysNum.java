package DZ.DZ3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArraysNum implements Iterable<Integer>{    
    private List<Integer> numbers;

    public ArraysNum() {
        numbers = new ArrayList<>();
    }

    public List<Integer> getNums() {
        return numbers;
    }

    public void addNums(Integer num) {
        numbers.add(num);
    }

    @Override
    public Iterator<Integer> iterator() {        
        return new ArraysIterator();
    }

    class ArraysIterator implements Iterator<Integer>{
        int index = 0;

        @Override
        public boolean hasNext() {            
            return index < numbers.size();
        }

        @Override
        public Integer next() {            
            return numbers.get(index++);
        }        
    }    
}
