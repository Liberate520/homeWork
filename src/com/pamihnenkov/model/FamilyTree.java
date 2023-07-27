package com.pamihnenkov.model;

import com.pamihnenkov.model.enums.Relation;

import java.io.Serial;
import java.io.Serializable;
import java.time.Period;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FamilyTree implements Serializable, Iterable<Human> {

    @Serial
    private static final long serialVersionUID = 1L;
    private final Set<Human> humanList = new HashSet<>();

    public FamilyTree(Human human) {
        addFamilyMember(human);
    }

    public Set<Human> getBrothersAndSister(Human person){
        return person.getParents().stream()
                .map(Human::getChilds)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

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

    public Human findOldestMember(){
        return humanList.stream().min((h1,h2) -> Period.between(h2.getBirthDate(),h1.getBirthDate()).getYears()).get();
    }

    public void printSortedByBirthdate(){
        System.out.println("Список людей отсортированный по дате рождения: ");
        humanList.stream().sorted(Comparator.comparing(Human::getBirthDate)).forEach(System.out::println);
    }

    public void printSortedByAge(){
        System.out.println("Список людей отсортированный по возрасту: ");
        humanList.stream().sorted((h1,h2) -> h1.getAge()- h2.getAge()).forEach(System.out::println);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("Семейное дерево:\n");
        for (Human human : humanList){
            sb.append(human).append('\n');
        }
        return sb.toString();
    }

    @Override
    public Iterator<Human> iterator() {
        return humanList.iterator();
    }
}
