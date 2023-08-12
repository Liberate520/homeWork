package com.pamihnenkov.model;

import com.pamihnenkov.helpers.serialization.ComparatorByBirthday;
import com.pamihnenkov.model.enums.Relation;

import java.io.Serial;
import java.io.Serializable;
import java.time.Period;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FamilyTree<T extends FamilyTreeMember<T>> implements Serializable, Iterable<T> {

    @Serial
    private static final long serialVersionUID = 1L;
    private final Set<T> memberList = new HashSet<>();

    public FamilyTree() {

    }
    public Set<T> getBrothersAndSistersForMember(T member){
        return member.getParents().stream()
                .map(T::getChilds)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }
    public void addFamilyMember (T newMember){
        memberList.add(newMember);
        newMember.getChilds().stream().filter(Predicate.not(memberList::contains)).forEach(memberList::add);
        newMember.getParents().stream().filter(Predicate.not(memberList::contains)).forEach(memberList::add);
        newMember.getChilds().stream().filter(memberList::contains).forEach(child -> child.addParent(newMember));
        newMember.getParents().stream().filter(memberList::contains).forEach(parent -> parent.addChild(newMember));
    }
    public void addRelativeForPerson(T member, T relative, Relation relation){
        if (relation == Relation.PARENT) relative.addChild(member);
        if (relation == Relation.CHILD) relative.addParent(member);
        addFamilyMember(relative);
    }
    public T findOldestMember(){
        return memberList.stream().min((h1, h2) -> Period.between(h2.getBirthDate(),h1.getBirthDate()).getYears()).get();
    }

    public Set<T> getSortedByBirthdate(){
        Set<T> result = new TreeSet<>(new ComparatorByBirthday<T>());
        result.addAll(memberList);
        return result;
    }
    public Set<T> getSortedByAge(){
        Set<T> result = new TreeSet<>(Comparator.comparingInt(FamilyTreeMember::getAge));
        result.addAll(memberList);
        return result;
    }

    public Set<T> getAllMembers(){
        return memberList;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("Семейное дерево:\n");
        for (T member : memberList){
            sb.append(member).append('\n');
        }
        return sb.toString();
    }
    @Override
    public Iterator<T> iterator() {
        return memberList.iterator();
    }
}
