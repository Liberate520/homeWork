package familyRecords;

import human.Human;
import human.Connection;
import converter.Converter;
import family.Family;

import java.io.Serializable;
import java.util.*;

public class FamilyRecords implements Serializable, Iterable<Family> {
    private List<Family> families;
    public FamilyRecords(){
        families = new ArrayList<>();
    }


    public void addHumanToFamily(Human human, Family family) {
        human.addFamily(family);
        family.addHuman(human);
    }

    public void addFamily(String name, Human familyMember) {
        Family newFamily = searchFamilyBeName(name);
        if (newFamily == null) {
            newFamily = new Family(name);
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
    public Human searchHumanByName(String name) {
        for (Family family : families) {
            for (Human human : family.getMembers()) {
                if (human.getName().equals(name)) return human;
            }
        }
        return null;
    }

    /**
     * Search Family by his name
     * @param name name to search
     * @return First founded family or null
     */
    public Family searchFamilyBeName(String name) {
        for (Family family : families) {
            if (family.getName().equals(name)) return family;
        }
        return null;
    }

    /**
     * Connect humans to each other
     */
    public void addConnection(Human humanFrom, Connection connection, Human humanTo) {
        humanFrom.addConnection(humanTo, connection);
        if (connection.opposite() != null) humanTo.addConnection(humanFrom, connection.opposite());
    }

    /**
     * Add wife to 'family' and set correct connections
     * 'family', 'husband' and 'wife' must exist and be members of this records
     */
    public void addWife(Family family, Human husband, Human wife) {
        addHumanToFamily(wife, family);
        addConnection(husband, Connection.HUSBAND, wife);
    }

    /**
     * Add child to 'family' and set correct connections
     * 'family', 'parent' and 'child' must exist and be members of this records
     */
    public void addChild(Family family, Human parent, Human child) {
        addHumanToFamily(child, family);
        addConnection(parent, Connection.PARENT, child);
    }

    /**
     * Add children from 'child' list to 'parents' list
     * All objects must exist and be members of this records
     */
    public void addChildren(Family family, List<Human> parents, List<Human> children) {
        for (Human parent : parents) {
            for (Human child : children) {
                addChild(family, parent, child);
            }
        }
    }

    /**
     * Add parent to 'family' and set correct connections
     * 'family', 'parent' and 'child' must exist and be members of this records
     */
    public void addParent(Family family, Human child, Human parent) {
        addHumanToFamily(parent, family);
        addConnection(parent, Connection.PARENT, child);
    }

    /**
     * return Set of Humans to whom this human is $connection
     */
    public Set<Human> findRelatedMembers(Human human, Connection connection) {
        Set<Human> result = new HashSet<>();
        if (human != null) {
            result = human.getRelatedMembers(connection);
        }
        return result;
    }

    /**
     * return Set of all other families that are connected to members of current Family
     */
    public Set<Family> findConnectedFamilies(Family family) {
        Set<Family> result = new HashSet<>();
        for (Human member : family.getMembers()) {
            for (Family connectedFamily : member.getFamilies()) {
                if (!connectedFamily.equals(family)) result.add(connectedFamily);
            }
        }
        return result;
    }

    public Set<Human> getPeople() {
        Set<Human> result = new HashSet<>();
        for (Family family : families) {
            result.addAll(family.getMembers());
        }
        return result;
    }

    /**
     * Build and return string of families
     */
    public String getFamiliesString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Family family:this) {
            stringBuilder.append(family);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    public void sort() {Collections.sort(families);}
    public void save(Converter converter) {
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
    public Iterator<Family> iterator() {
        return families.iterator();
    }
}
