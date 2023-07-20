package Model.FamilyTree;

import Model.Comparator.FamilyTreeObjectComparatorByName;
import Model.FamilyTreeObject.FamilyTreeObject;
import Model.Comparator.FamilyTreeObjectComparatorByGender;




import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;



public class FamilyTree<E extends FamilyTreeObject> implements Serializable, Iterable{
    private List<E > elements = new ArrayList<E>();

    public void addElement(E e){
        elements.add(e);
    }

    public Boolean checkElement(String name, String surname){
        for (E o: elements) {
            if(o.getName().equals(name)&&o.getSurname().equals(surname)){
                return true;
            }

        }
        return false;
    }

    public Boolean deleteElement(String name, String surname){
        return elements.remove(getElement(name, surname));

    }
    public E getElement(String name, String surname){
        for(E e: elements){
            if(e.getName().equals(name) && e.getSurname().equals(surname)){
                return e;
            }

        }
        return null;
    }

    public String getElementInfo(E e){
        return e.toString();
    }


    public String elemensPrint(){
        return elements.toString();
    }

    public List elementsSort(){
        Collections.sort(elements);
        return elements;
    }

    public List elementsSortByName(){
        Collections.sort(elements, new FamilyTreeObjectComparatorByName());
        return elements;
    }


    public List elementsSortByGender(){
        Collections.sort(elements, new FamilyTreeObjectComparatorByGender());
        return elements;
    }


    @Override
    public Iterator<E> iterator() {
        return elements.iterator();
    }
}
