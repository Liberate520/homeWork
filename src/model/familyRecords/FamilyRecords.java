package model.familyRecords;

import model.member.Connection;
import model.converter.Converter;
import model.family.Family;
import model.member.Member;

import java.io.Serializable;
import java.util.*;

public class FamilyRecords<E extends Member> implements Serializable, Iterable<Family<E>> {
    private List<Family<E>> families;
    public FamilyRecords(){
        families = new ArrayList<>();
    }


    public void addToFamily(E member, Family<E> family) {
        member.addFamily(family);
        family.addHuman(member);
    }

    public void addFamily(String name, E familyMember) {
        Family<E> newFamily = searchFamilyByName(name);
        if (newFamily == null) {
            newFamily = new Family<>(name);
            families.add(newFamily);
        }
        if (familyMember != null) {
            addToFamily(familyMember, newFamily);
        }
    }

    public void addFamily(String name) {
        this.addFamily(name, null);
    }

    /**
     * Search Human by name
     * @param name name to search
     * @return First founded model.human or null
     */
    public E searchHumanByName(String name) {
        for (Family<E> family : families) {
            for (E member : family.getMembers()) {
                if (member.getName().equals(name)) return member;
            }
        }
        return null;
    }

    /**
     * Search Family by his name
     * @param name name to search
     * @return First founded model.family or null
     */
    public Family<E> searchFamilyByName(String name) {
        for (Family<E> family : families) {
            if (family.getName().equals(name)) return family;
        }
        return null;
    }

    /**
     * Connect humans to each other
     */
    public void addConnection(E humanFrom, Connection connection, E humanTo) {
        humanFrom.addConnection(humanTo, connection);
        if (connection.opposite() != null) humanTo.addConnection(humanFrom, connection.opposite());
    }

    /**
     * Add wife to 'model.family' and set correct connections
     * 'model.family', 'husband' and 'wife' must exist and be members of this records
     */
    public void addWife(Family<E> family, E husband, E wife) {
        addToFamily(wife, family);
        addConnection(husband, Connection.HUSBAND, wife);
    }

    /**
     * Add child to 'model.family' and set correct connections
     * 'model.family', 'parent' and 'child' must exist and be members of this records
     */
    public void addChild(Family<E> family, E parent, E child) {
        addToFamily(child, family);
        addConnection(parent, Connection.PARENT, child);
    }

    /**
     * Add children from 'child' list to 'parents' list
     * All objects must exist and be members of this records
     */
    public void addChildren(Family<E> family, List<E> parents, List<E> children) {
        for (E parent : parents) {
            for (E child : children) {
                addChild(family, parent, child);
            }
        }
    }

    /**
     * Add parent to 'model.family' and set correct connections
     * 'model.family', 'parent' and 'child' must exist and be members of this records
     */
    public void addParent(Family<E> family, E child, E parent) {
        addToFamily(parent, family);
        addConnection(parent, Connection.PARENT, child);
    }

    /**
     * return Set of Humans to whom this model.human is $connection
     */
    public Set<? extends Member> findRelatedMembers(E human, Connection connection) {
        Set<? extends Member> result = new HashSet<>();
        if (human != null) {
            result = human.getRelatedMembers(connection);
        }
        return result;
    }

    /**
     * return Set of all other families that are connected to members of current Family
     */
    public Set<Family<? extends Member>> findConnectedFamilies(Family<E> family) {
        Set<Family<? extends Member>> result = new HashSet<>();
        for (E member : family.getMembers()) {
            for (Family<? extends Member> connectedFamily : member.getFamilies()) {
                if (!connectedFamily.equals(family)) result.add(connectedFamily);
            }
        }
        return result;
    }

    public Set<E> getPeople() {
        Set<E> result = new HashSet<>();
        for (Family<E> family : families) {
            result.addAll(family.getMembers());
        }
        return result;
    }

    /**
     * Build and return string of families
     */
    public String getFamiliesString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Family<E> family:this) {
            stringBuilder.append(family);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    public void sort() {Collections.sort(families);}
    public void save(Converter<E> converter) {
        converter.save(this);
    }
    public List<Family<E>> getFamilies() {
        return families;
    }
    @Override
    public Iterator<Family<E>> iterator() {
        return families.iterator();
    }
}
