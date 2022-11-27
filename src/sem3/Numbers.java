import java.util.ArrayList;
import java.util.Iterator;

public class Numbers implements Iterable<Num>{
    private ArrayList <Num> myNumbers;

    public Numbers() {
        myNumbers = new ArrayList<Num>(); 
    }
    public ArrayList<Num> getMyNumbers() {
        return myNumbers;
    }
    public void addNumbers(Integer number) {
        Num n = new Num(number);
        myNumbers.add(n);
    }
    public void sortNumEnd(){ //метод сортировки по последней цифре
       myNumbers.sort(new NumComporator());
    }
    @Override
    public Iterator<Num> iterator() {
        return myNumbers.iterator();
    }
}