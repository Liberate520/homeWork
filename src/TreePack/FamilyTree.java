package TreePack;

import PersonPack.ComporatorsPack.PersonComparatorByAge;
import PersonPack.ComporatorsPack.PersonComparatorByChildren;
import PersonPack.Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FamilyTree <E extends TreeItem<E>> implements Serializable, Iterable<E> {
    private HashMap<Integer, E> personList;
    private int personId = 0;
    public FamilyTree() {
        this.personList = new HashMap<Integer, E>();
    }

    public void addPerson(E person){
        this.personList.put(personId++,person);
    }

    public void setParent1(E person, E parent){
        person.setParent1(parent);
        if (! parent.getChildren().contains(person)){
            parent.addChild(person);
        }
    }
    public void setParent2(E person, E parent){
        person.setParent2(parent);
        if (! parent.getChildren().contains(person)){
            parent.addChild(person);
        }
    }

    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder("Family tree:\n");
        for (Map.Entry<Integer, E> item : personList.entrySet()){
            tmp.append(item.getValue().toString());
            tmp.append("\n");
        }

        return tmp.toString();
    }

//спросить что это такое!!!!!!!!
//    @Override
//    public void forEach(Consumer<? super Person> action) {
//        Iterable.super.forEach(action);
//    }

    @Override
    public Iterator<E> iterator() {
        return new PersonIterator(personList);
    }
    public ArrayList<String> sortByAge(){
        ArrayList<String> result = new ArrayList<String>();
        personList.entrySet().stream()
                .sorted(new PersonComparatorByAge())
                .forEach(e -> result.add(((Map.Entry<?, ?>) e).getValue().toString()));
        return result;
    }

    public void sortByChildren(){
        //personList.entrySet().stream().sorted(new PersonComparatorByChildren()).forEach(e -> System.out.println(e.getValue().toString()));
        personList.entrySet().stream()
                .sorted(new PersonComparatorByChildren())
                .forEach(e -> System.out.println(((Map.Entry<?, ?>) e).getValue().toString()));
    }

}
