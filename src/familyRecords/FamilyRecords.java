package familyRecords;

import member.Connection;
import converter.Converter;
import family.Family;
import member.Member;

import java.io.Serializable;
import java.util.*;

public class FamilyRecords<E extends Member> implements Serializable, Iterable<Family<E>> {
    private List<Family<E>> families;
    public FamilyRecords(){
        families = new ArrayList<>();
    }


    public void addHumanToFamily(E member, Family<E> family) {
        member.addFamily(family);
        family.addHuman(member);
    }

    public void addFamily(String name, E familyMember) {
        Family<E> newFamily = searchFamilyBeName(name);
        if (newFamily == null) {
            newFamily = new Family<E>(name);
            families.add(newFamily);
        }
        if (familyMember != null) {
            addHumanToFamily(familyMember, newFamily);
        }
    }

    public void addFamily(String name) {
        this.addFamily(name, null);
    }

    /**
     * Search Human by name
     * @param name name to search
     * @return First founded human or null
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
     * @return First founded family or null
     */
    public Family<E> searchFamilyBeName(String name) {
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
     * Add wife to 'family' and set correct connections
     * 'family', 'husband' and 'wife' must exist and be members of this records
     */
    public void addWife(Family<E> family, E husband, E wife) {
        addHumanToFamily(wife, family);
        addConnection(husband, Connection.HUSBAND, wife);
    }

    /**
     * Add child to 'family' and set correct connections
     * 'family', 'parent' and 'child' must exist and be members of this records
     */
    public void addChild(Family<E> family, E parent, E child) {
        addHumanToFamily(child, family);
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
     * Add parent to 'family' and set correct connections
     * 'family', 'parent' and 'child' must exist and be members of this records
     */
    public void addParent(Family<E> family, E child, E parent) {
        addHumanToFamily(parent, family);
        addConnection(parent, Connection.PARENT, child);
    }

    /**
     * return Set of Humans to whom this human is $connection
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
    public static FamilyRecords load(Converter converter) {
        return converter.load();
    }
//    public void load(Converter converter) {
//        // TODO: modify construction to something like 'this = converter.load();', when/if i understand how to do it
//        // Not sure if this way to load data is correct
//        FamilyRecords loadedRecords = converter.load();
//        this.people = loadedRecords.people;
//        this.families = loadedRecords.families;
//    }
    @Override
    public Iterator<Family<E>> iterator() {
        return families.iterator();
    }
}
