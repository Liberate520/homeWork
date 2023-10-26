package home_work_class.FamilyTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends InterfaceMethod> implements Serializable, Iterable<T> {
    private List<T> humansList;

    public FamilyTree() {
        humansList = new ArrayList<>();
    }

    public String showHumansList(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-----Список корневого древа-----\n");
        for (T o: humansList) {
            stringBuilder.append(o);
            stringBuilder.append("\n");
            stringBuilder.append("----------------------------\n");
        }
        return stringBuilder.toString();
    }

    public void addHuman(T o){
        if (! humansList.contains(o)){
            humansList.add(o);}
    }

    public List<T> findHumanByName(String name){
        List<T> findHuman = new ArrayList<>();
        for (T o: humansList) {
            if (o.getName().equals(name)){findHuman.add(o);}
        }
        return findHuman;
    }

    public void sortByName(){
        humansList.sort(new HumanComparatorByName<>());
    }

    public void sortByAge(){
        humansList.sort(new HumanComparatorByAge<>());
    }

    public void  sortById() { humansList.sort(new HumanComparatorById<>());}
    @Override
    public Iterator<T> iterator() {return humansList.iterator(); }
}
