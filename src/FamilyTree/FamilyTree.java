package src.FamilyTree;

import src.Comparators.FamilyTreeIterator;
import src.Comparators.PersonComparatorByName;
import src.Comparators.PersonCompareByBirthday;
import src.Comparators.PersonCompareByYearOfReign;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<T extends FTObjects> implements Serializable, Iterable{
    private ArrayList<T> people;

    public FamilyTree() {
        this(new ArrayList<T>());
    }

    public FamilyTree(ArrayList<T> people) {
        this.people = people;
    }

    public T getByName(String name) {
        for (T human : people) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    public ArrayList<T> getFamilyTree(ArrayList<T> people){
        return people;
    }

    /**
     * The method of adding persons who appeared from outside (for example, the wife)
     */
    public boolean addPerson(T person) {
        for (T human : people) {
            if (person.getName().equals(human.getName())) {
                return false;
            }
        }
        people.add(person);
        return true;
    }

    public  boolean addWifeToHusband(String husbandName, T person){
        for (T item : people) {
            if (person.getName().equals(item.getName())) {
                return false;
            }
        }
        person.addSposeName(husbandName);
        people.add(person);
        for (T men : people){
            if (husbandName.equals(men.getName())){
                men.addSposeName(person.getName());
            }
        }
        return true;
    }

    public void getList() {
        for (T item : people) {
            System.out.println(item);
        }
    }


    public void addChildToMother(String motherName, T person) {
        T mother = getByName(motherName);
        mother.setChildrenName(person.getName());
        people.add(person);
        System.out.printf("%s is added to the mother\n",person.getName());
                    for (T father : people){
                        if (father.getSpouseName().contains(motherName)){
                            father.setChildrenName(person.getName());
                            System.out.printf("%s is added to the father\n",person.getName());
                        }
                    }
    }

    public T findSpouse(String name) {
        T human = getByName(name);
        for (T spouse : people) {
            if (human.getSpouseName().contains(spouse.getName())) {
                System.out.println(spouse.getName());
                return spouse;
            }
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new FamilyTreeIterator<T>((ArrayList<T>) people);
    }

    public void sortByName() {
        Collections.sort(people, new PersonComparatorByName<T>());
    }

    public String sortByBirthday() {
        Collections.sort(people, new PersonCompareByBirthday<T>());
        StringBuilder str1 = new StringBuilder("\n\t\tPersons of the family tree\n");
        for (T human: people){
            str1.append("\nPerson ").append(human.getName()).append(" lived in ").append(human.getBirthDay()).append(" - ").append(human.getDeathDay());
            if (!(human.getSpouseName().isEmpty())){
                str1.append("\t, spouse - ").append(human.getSpouseName().toString().replace("[", "").replace("]", ""));
            }
            if(!(human.getChildrenName().isEmpty())) {
                str1.append("\n\tChildren: ").append(human.getChildrenName().toString().replace("[", "").replace("]", ""));
            }
            if(human.getAdditionalField() != null) {
                str1.append("\n\t\treigned in ").append(human.getAdditionalField()).append(" years;");
            }
        }
        return str1.toString();
    }

    public String sortByYearOfReigh(){
        List<T> family = new ArrayList<>();
        for (T human: people) {
            if (human.getAdditionalField() != null){
                family.add(human);
            }
        }
        Collections.sort(family, new PersonCompareByYearOfReign<T>());
        StringBuilder str2 = new StringBuilder("\n\tThe years of the reign of the reigning personages\n");
        for (T human: family){
            str2.append("\nPerson ").append(human.getName());
            str2.append(" reigned in ");
            str2.append(human.getAdditionalField()).append(" years;");

        }
        return str2.toString();
    }
}


