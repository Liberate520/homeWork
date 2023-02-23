import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable{
    private ArrayList<Person> people;

    public FamilyTree() {
        this(new ArrayList<Person>());
    }

    public FamilyTree(ArrayList<Person> people) {
        this.people = people;
    }

    public Person getByName(String name) {
        for (Person human : people) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    /**
     * The method of adding persons who appeared from outside (for example, the wife)
     */
    public boolean addPerson(Person person) {
        for (Person item : people) {
            if (person.getName().equals(item.getName())) {
                return false;
            }
        }
        people.add(person);
        return true;
    }

    public  boolean addWifeToHusband(String husbandName, Person person){
        for (Person item : people) {
            if (person.getName().equals(item.getName())) {
                return false;
            }
        }
        person.addSposeName(husbandName);
        people.add(person);
        for (Person men : people){
            if (husbandName.equals(men.getName())){
                men.addSposeName(person.getName());
            }
        }
        return true;
    }

    public void getList() {
        for (Person item : people) {
            System.out.println(item);
        }
    }


    public boolean addChildToMother(String motherName, Person person) {
        for (Person mother : people) {
            if (mother.getName().equals(motherName)) {
                if (!mother.getChildrenName().contains(person.getName())) {
                    people.add(person);
                    mother.setChildrenName(person.getName());
                    for (Person father : people){
                        if (father.getSpouseName().contains(motherName)){
                            father.setChildrenName(person.getName());
                            return true;
                        }
                    }
                }
            }
        }
        System.out.println("Check for parents");
        return false;
    }

    public Person findSpouse(String name){
        for (Person human : people){
            if (name.contains(human.getName())){
                for (Person item: people){
                    if (human.getSpouseName().contains(item.getName())){
                        System.out.println(item.getName());
                        return item;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public Iterator iterator() {
        return new FamilyTreeIterator(people);
    }

    public void sortByName() {
        Collections.sort(people, new PersonComparatorByName());
    }

    public void sortByBirthday() {
        Collections.sort(people, new PersonCompareByBirthday());
    }

    public void sortByYearOfReigh(){
        List<Person> family = new ArrayList<Person>();
        for (Person human: people) {
            if (human.getAdditionalField() != null){
                family.add(human);
            }
        }
        Collections.sort(family, new PersonCompareByYearOfReign());
        for (Person human: family){
            System.out.printf("%s he reigned %s\n",human.getName(), human.getAdditionalField());
        }
    }
}


