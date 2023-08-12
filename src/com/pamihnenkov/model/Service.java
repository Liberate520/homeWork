package com.pamihnenkov.model;

import com.pamihnenkov.helpers.serialization.FileHandler;
import com.pamihnenkov.helpers.serialization.Writeable;
import com.pamihnenkov.model.enums.Gender;
import com.pamihnenkov.model.enums.Relation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.UUID;

public class Service {
    private FamilyTree<Human> familyTree;
    private Writeable persistance;

    public Service() {
        this.familyTree = new FamilyTree<>();
        this.persistance = new FileHandler();
    }

    public void load(){
        Object input = persistance.load();
        if (input instanceof Human) familyTree = (FamilyTree<Human>) input;
    }

    public void save(){
        persistance.save(familyTree);
    }

    public Set<Human> getBrothersAndSisters(Human member){
        return familyTree.getBrothersAndSistersForMember(member);
    }

    public Set<Human> getAllMembers(){
        return familyTree.getAllMembers();
    }

    public Human getMemberById(UUID id){
        return familyTree.getAllMembers().stream().filter(member -> member.getId().equals(id)).findFirst().get();
    }

    public void addRelativeForPerson(UUID member, UUID relative, String relation){

        familyTree.addRelativeForPerson(getMemberById(member), getMemberById(relative), Relation.valueOf(relation));
    }

    public Set<Human> getSortedByBirthdate(){
        return familyTree.getSortedByBirthdate();
    }

    public Set<Human> getSortedByAge(){
        return familyTree.getSortedByAge();
    }

    public void addNewMember(String surname, String name, String lastname, String birthDate, String deathDate, String gender){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Human newMember = new Human(UUID.randomUUID(),
                name,
                surname,
                lastname,
                LocalDate.parse(birthDate,formatter),
                (deathDate == null || deathDate.length() == 0) ? null : LocalDate.parse(deathDate,formatter),
                gender.equals("м") ? Gender.MALE : Gender.FEMALE);
        familyTree.addFamilyMember(newMember);
    }
}
