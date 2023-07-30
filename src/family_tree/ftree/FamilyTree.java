package family_tree.ftree;

import family_tree.person.Gender;
import family_tree.person.Person;
import family_tree.person.PersonsComparatorByNames;
import family_tree.person.PersonsComparatorByBirthday;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Person> {
    
    private List<Person> relations;

    public FamilyTree(List<Person> relations){
        this.relations = relations;
    }

    public FamilyTree(){
        this(new ArrayList<>());
    }

    public void addPerson(Person person){
        relations.add(person);
    }
    
    public String getFullRelativesInfo(){
        StringBuilder sB = new StringBuilder();
        sB.append("\n============\n");
        sB.append("Full Family tree:\n");
        sB.append("============\n");
        for (Person person: relations){
            sB.append(person.getID());
            sB.append(". ");
            sB.append(person.getPerson());
            if (person.getMother() != null || person.getFather() != null){
                sB.append("\n :: Parents: ");
                if (person.getMother().getPerson() != null){
                    sB.append(person.getMother().getPerson());
                }
                if (person.getMother() != null && person.getFather() != null) {
                    sB.append(" & ");
                }
                if (person.getFather().getPerson() != null) {
                    sB.append(person.getFather().getPerson());
                }
            }
            sB.append(getChildrensInfo(person.getID()));
            sB.append(getSiblings(person.getMother(), person.getFather(), person.getID()));
            sB.append("\n------------\n");
        }

        return sB.toString();
    }

    public String getPersonalTree(int id){
        StringBuilder sB = new StringBuilder();
        for (Person person: relations) {
            if (person.getID() == id) {
                sB.append("\n============\n");
                sB.append(person.getID());
                sB.append(". ");
                sB.append(person);
                sB.append(getChildrensInfo(person.getID()));
                sB.append(getSiblingsFull(person.getMother(), person.getFather(), person.getID()));
                sB.append("\n============\n");
                return sB.toString();
            }
        }
        return sB.toString();
    }
    public String getSiblingsFull(Person mother, Person father, long id){

        List <Person> result = new ArrayList<>();
        StringBuilder sB = new StringBuilder();

        for (Person person: relations){
            if (person.getID() != id && ((person.getMother() != null && person.getMother() == mother) || 
                (person.getFather() != null && person.getFather() == father))){
                    result.add(person);
            }
        }

        if (result.size() > 0){
            for(Person entry: result){
                if (entry.getGender() == Gender.Female){
                    sB.append("\n :: Sister: ");
                    sB.append(result);
                } else {
                    sB.append("\n :: Brother: ");
                    sB.append(result);
                }
            }
        }
        return sB.toString();
    }

    public String getSiblings(Person mother, Person father, long id){

        List <Person> result = new ArrayList<>();
        StringBuilder sB = new StringBuilder();

        for (Person person: relations){
            if (person.getID() != id && ((person.getMother() != null && person.getMother() == mother) ||
                    (person.getFather() != null && person.getFather() == father))){
                result.add(person);
            }
        }

        if (result.size() > 0){
            for(Person entry: result){
                if (entry.getGender() == Gender.Female){
                    sB.append("\n ::=:: Sister: ");
                    sB.append(entry.getPerson());
                } else {
                    sB.append("\n ::=:: Brother: ");
                    sB.append(entry.getPerson());
                }
            }
        }
        return sB.toString();
    }

    public String getChildrensInfo(long id){
        StringBuilder sB = new StringBuilder();
        sB.append(getChildrensList(id));
        return sB.toString();
    }

    public String getChildrensList(long id){
        List <Person> result = new ArrayList<>();
        StringBuilder sB = new StringBuilder();

        for (Person person: relations){
            if (person.getID() != id && ((person.getMother() != null && person.getMother().getID() == id) ||
                    (person.getFather() != null && person.getFather().getID() == id))){
                result.add(person);
            }
        }

        if (result.size() > 0){
            for(Person entry: result){
                if (entry.getGender() == Gender.Female){
                    sB.append("\n ::>> Daughter: ");
                    sB.append(entry.getPerson());
                } else {
                    sB.append("\n ::>> Son: ");
                    sB.append(entry.getPerson());
                }
            }
        }
        return sB.toString();
    }

    public void sortByNames(){
        relations.sort(new PersonsComparatorByNames());
    }

    public void sortByBirthDays(){
        relations.sort(new PersonsComparatorByBirthday());
    }

    @Override
    public Iterator<Person> iterator() {
        return new FamilyTreeIterator(relations);
    }

}
