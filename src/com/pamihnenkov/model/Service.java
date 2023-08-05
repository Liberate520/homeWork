package com.pamihnenkov.model;

import com.pamihnenkov.model.enums.Relation;

import java.util.Set;
import java.util.UUID;

public class Service<T extends FamilyTreeMember<T>>{
    private FamilyTree<T> familyTree;

    public Service() {
        this.familyTree = new FamilyTree<>();
    }

    public Set<T> getBrothersAndSisters(T member){
        return familyTree.getBrothersAndSister(member);
    }

    public Set<T> getAllMembers(){
        return familyTree.getAllMembers();
    }

    public T getMemberById(UUID id){
        return familyTree.getAllMembers().stream().filter(member -> member.getId().equals(id)).findFirst().get();
    }

    public void addRelativeForPerson(UUID member, UUID relative, String relation){

        familyTree.addRelativeForPerson(getMemberById(member), getMemberById(relative), Relation.valueOf(relation));
    }

    public Set<T> getSortedByBirthdate(){
        return familyTree.getSortedByBirthdate();
    }

    public Set<T> getSortedByAge(){
        return familyTree.getSortedByAge();
    }

    public void addNewMember(T member){
        familyTree.addFamilyMember(member);
    }
}
