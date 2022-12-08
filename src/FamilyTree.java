

import java.util.ArrayList;
import java.util.List;

public class FamilyTree <T> implements interfaceFamilyTree<T>{
    private List<T> list;

    private FamilyTree(List<T> list) {
        this.list = list;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public void add(T t) {
        list.add(t);
    }

    @Override
    public void find(T t) {
        System.out.println(list.get(list.indexOf(t)));
    }

    @Override
    public void find(String name) {
        for (T t : list) {
            if (((Human)t).getName().indexOf(name) >= 0){
                System.out.println("Результат поиска: " + t);
            }
        }
    }
    
    
    

    @Override
    public String toString() {        
        return  list.toString();        
    }    
}
