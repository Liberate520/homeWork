import java.util.ArrayList;
import java.util.Iterator;

public class Tree<T extends Printable> implements Iterable<T> {
    T union;
    private ArrayList<T> myTree = new ArrayList<T>();
    private ArrayList<T> children = new ArrayList<T>();






    public void createTreeT(T union) {
        myTree.add(union);
    }




    public ArrayList<T> findChildren(T mom, T dad){
        for(int i = 0; i< myTree.size(); i++){
            if((myTree.get(i).getMom() == mom) && ((myTree.get(i)).getDad() == dad)){
                children.add(myTree.get(i));
            }


        }


        return children;
    }



    @Override
    public Iterator<T> iterator() {
        return new TreeIterator();

    }



    class TreeIterator implements Iterator <T>{
        int index = 0;

        public boolean hasNext(){
            return index < myTree.size();
        }

        public T next(){
            return myTree.get(index++);
        }
    }


}



