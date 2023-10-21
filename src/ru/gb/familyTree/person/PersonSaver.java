package ru.gb.familyTree.person;

import ru.gb.familyTree.tree.FamilyTree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonSaver {
    private FamilyTree family;
    private List<Person> personList = new ArrayList<>();

    public PersonSaver(FamilyTree family, List<Person> personList){
        this.family = family;
        this.personList = personList;
    }

    public boolean addPerson(Person person){
        Person temp = new PersonBuilder().createPerson();
        temp.setId(person.getId()); temp.setGender(person.getGender());temp.setFirstName(person.getFirstName());
        temp.setSecondName(person.getSecondName()); temp.setLastName(person.getLastName());
        temp.setStartDay(person.getStartDay()); temp.setStopDay(person.getStopDay());
        return personList.add(temp);
    }
    public Person getObjectById (int id){
        for (Person itm: personList) {
            if (itm.getId() == id) return itm;
        }
        return null;
    }
    
}
