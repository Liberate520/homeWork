package TreePack;

import PersonPack.ComporatorsPack.PersonComparatorByAge;
import PersonPack.ComporatorsPack.PersonComparatorByChildren;
import PersonPack.Person;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FamilyTree implements Serializable, Iterable<Person> {
    private HashMap<Integer, Person> personList;
    private int personId = 0;
    public FamilyTree() {
        this.personList = new HashMap<Integer, Person>();
    }

    public void addPerson(Person person){
        this.personList.put(personId++,person);
    }

    public void setParent1(Person person, Person parent){
        person.setParent1(parent);
        if (! parent.getChildren().contains(person)){
            parent.addChild(person);
        }
    }
    public void setParent2(Person person, Person parent){
        person.setParent2(parent);
        if (! parent.getChildren().contains(person)){
            parent.addChild(person);
        }
    }

    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder("Family tree:\n");
        for (Map.Entry<Integer, Person> item : personList.entrySet()){
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
    public Iterator<Person> iterator() {
        return new PersonIterator(personList);
    }
    public void sortByAge(){
        personList.entrySet().stream().sorted(new PersonComparatorByAge()).forEach(e -> System.out.println(e.getValue().toString()));
    }

    public void sortByChildren(){
        personList.entrySet().stream().sorted(new PersonComparatorByChildren()).forEach(e -> System.out.println(e.getValue().toString()));
    }

}
