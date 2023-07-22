package com.pamihnenkov;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FamilyTree {
    private Set<Human> humanList = new HashSet<>();

    public FamilyTree(Human human) {
        addFamilyMember(human);
    }

    public Set<Human> getBrothersAndSister(Human person){
        return person.getParents().stream()
                .map(Human::getChilds)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

   // public void addParent (Human person){
   //     if (person.getChilds().stream().anyMatch(humanList::contains)){
   //         addFamilyMember(person);
   //     } else System.err.println("Родственные связи не установлены. (Вероятно требуется добавить промежуточных родственников)");
   // }

   // public void addChild (Human person){
   //     if (person.getParents().stream().anyMatch(humanList::contains)){
   //         addFamilyMember(person);
   //     } else System.err.println("Родственные связи не установлены. (Вероятно требуется добавить промежуточных родственников)");
   // }

    private void addFamilyMember (Human newMember){
        humanList.add(newMember);
        newMember.getChilds().stream().filter(Predicate.not(humanList::contains)).forEach(humanList::add);
        newMember.getParents().stream().filter(Predicate.not(humanList::contains)).forEach(humanList::add);
        newMember.getChilds().stream().filter(humanList::contains).forEach(child -> child.addParent(newMember));
        newMember.getParents().stream().filter(humanList::contains).forEach(parent -> parent.addChild(newMember));
    }

    public void addRelativeForPerson(Human member, Human relative, Relation relation){
        if (relation == Relation.PARENT) relative.addChild(member);
        if (relation == Relation.CHILD) relative.addParent(member);
        addFamilyMember(relative);
    }
}
