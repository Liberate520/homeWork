import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyCollectionCats implements Iterable<Cat> {

    private List<Cat> cats;

    public MyCollectionCats(){
        cats = new ArrayList<Cat>();
    }

    public Iterator<Cat> iterator(){
        return new MyIterator(this.cats);
    }

    public void addRandomeCats(int count) {
        for (int i = 0; i < count; i++){
            this.cats.add(new Cat());
        }
    }
    
    public void add(String name){
        this.cats.add(new Cat(name));
    }

    public Cat get(int index){
        return this.cats.get(index);
    }

    public int size(){
        return this.cats.size();
    }
}

