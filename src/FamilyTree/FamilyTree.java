package src.FamilyTree;

import src.Comparators.FamilyTreeIterator;
import src.Comparators.PersonComparatorByName;
import src.Comparators.PersonCompareByBirthday;
import src.Comparators.PersonCompareByYearOfReign;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<T extends FTObjects> implements Serializable, Iterable{
    private ArrayList<T> people;
    private Sex sex;

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

    public ArrayList<T> getFamilyTree(){
        return people;
    }

    public void getList() {
        for (T item : people) {
            System.out.println(item);
        }
    }

    public boolean addPersonToTree(String name, Integer birthDay, Integer deathDay, Sex sex, String additionalField) {
        T person = (T) new Person(name, birthDay, deathDay, sex, additionalField);
        for (T item : people) {
            if (person.getName().equals(item.getName())) {
                return false;
            }
        }
        return people.add((T) person);
    }

    public  boolean addWifeToHusband(String husbandName, String name, Integer birthDay, Integer deathDay, Sex sex, String additionalField){
        T person = (T) new Person( name, birthDay, deathDay, sex, additionalField);
        for (T item : people) {
            if (name.equals(item.getName())) {
                return false;
            }
        }
        people.add(person);
        person.addSpouseName(husbandName);
        T husband = getByName(husbandName);
        return(husband.addSpouseName(person.getName()));
    }

    public boolean addChildToMother(String motherName, String name, Integer birthDay, Integer deathDay, Sex sex, String additionalField) {
        T mother = getByName(motherName);
        T person = (T) new Person( name, birthDay, deathDay, sex, additionalField);
        for (T item : people) {
            if (name.equals(item.getName())) {
                return false;
            }
        }
        people.add(person);
        mother.setChildrenName(name);
        T husbandName = getByName(mother.getSpouseName().get(0));
        if (husbandName.setChildrenName(name)) {
            return true;
        }
        return false;
    }

    public ArrayList<T> listSpouse(String name){
        List<T> spouses = new ArrayList<>();
        T human = getByName(name);
        for (T spouse : people) {
            if (human.getSpouseName().contains(spouse.getName())) {
                spouses.add(spouse);
            }
        }
        return (ArrayList<T>) spouses;
    }

    public String findSpouse(String name) {
        StringBuilder str3 = new StringBuilder("\n\tList of spouses of the Person ").append(name).append("\n");
        if (listSpouse(name) != null) {
            for (T spouse : listSpouse(name)) {
                str3.append("\nPerson ").append(spouse.getName()).append(" lived in ").append(spouse.getBirthDay()).append(" - ").append(spouse.getDeathDay());
            }
        } else {
            str3.append("\n\tSpouses have not been found\n");
        }
        return str3.toString();
    }


    public ArrayList<T> listParents(String name) {
        List<T> parents = new ArrayList<>();
        for (T human : people) {
            if (human.getChildrenName().contains(name)) {
                if (human.getSex().equals(sex.Male)) {
                    T father = human;
                    parents.add(father);
                }
                else {
                    T mother = human;
                    parents.add(mother);
                }
            }
        }
        return (ArrayList<T>) parents;
    }

    public String findParents(String name) {
        StringBuilder str4 = new StringBuilder("\n\tList of Parents of the Person ").append(name).append("\n");
        if (listParents(name) != null) {
            if (listParents(name).size() >= 1 ) {
                T father = listParents(name).get(0);
                System.out.println(father);
                str4.append("\nFather ").append(father.getName()).append(" lived in ").append(father.getBirthDay()).append(" - ").append(father.getDeathDay());
                if (listParents(name).size() == 2) {
                    T mother = listParents(name).get(1);
                    str4.append("\nMother ").append(mother.getName()).append(" lived in ").append(mother.getBirthDay()).append(" - ").append(mother.getDeathDay());
                }
            }
        }
        return str4.toString();
    }

    public String remotePerson(String name){
        StringBuilder str5 = new StringBuilder("\n\tRemoving a person from the family tree ").append(name).append("\n");
        T humen = getByName(name);
        if(listParents(name) != null){
            for (int i = 0; i < listParents(name).size(); i++){
                listParents(name).get(i).getChildrenName().remove(name);
            }
        }
        str5.append("\n\tRemoving a person from parents list ");
        if ( listSpouse(name) != null){
            for (int j = 0; j < listSpouse(name).size(); j++){
                listSpouse(name).get(j).getSpouseName().remove(name);
            }
        }
        str5.append("\n\tRemoving a person from spouses list ");
        people.remove(humen);
        str5.append("\n\tRemoving a person from Family Tree ");
        return str5.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new FamilyTreeIterator( people);
    }

    public void sortByName() {
        Collections.sort(people, new PersonComparatorByName<T>());
    }

    public String getPersonByName(String name) {
        StringBuilder str0 = new StringBuilder("\n\tList of persons with a \"").append(name).append("\" in the name:\n");
        int j = 0;
        for (T human : people) {
            if (human.getName().contains(name)) {
                str0.append("\nPerson ").append(human.getName()).append(" lived in ").append(human.getBirthDay()).append(" - ").append(human.getDeathDay());
                j++;
                if (!(human.getSpouseName().isEmpty())){
                    str0.append("\t, spouse - ").append(human.getSpouseName().toString().replace("[", "").replace("]", ""));
                }
                if(!(human.getChildrenName().isEmpty())) {
                    str0.append("\n\tChildren: ").append(human.getChildrenName().toString().replace("[", "").replace("]", ""));
                }
                if(human.getAdditionalField() != null) {
                    str0.append("\n\t\treigned in ").append(human.getAdditionalField()).append(" years;");
                }
            }
        }
        if (j == 0) {str0.append("\n\tNo persons with the name \"").append(name).append("\" found");}
        return str0.toString();
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
        str1.append("\n\n\tEnd of the list");
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