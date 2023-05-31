package familyRecords;

import convertible.Convertible;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FamilyRecords implements Serializable {
    private Set<Human> people;
    private Set<Family> families;
    public FamilyRecords(){
        people = new HashSet<>();
        families = new HashSet<>();
    }

    public void addHuman(Human human) {
        people.add(human);
    }

    public void addHumans(List<Human> humans) {
        for (Human human : humans) {
            this.addHuman(human);
        }
    }

    public void addHumanToFamily(Human human, Family family) {
        human.addFamily(family);
        family.addHuman(human);
    }

    public void addFamily(String name, Human familyMember) {
        Family newFamily = searchFamilyBeName(name);
        if (newFamily == null) newFamily = new Family(name);
        families.add(newFamily);
        if (familyMember != null) {
            people.add(familyMember);
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
        for (Human human : people) {
            if (human.getName().equals(name)) return human;
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
    public void addConnection(Human humanFrom, FamilyConnection connection, Human humanTo) {
        humanFrom.addConnection(humanTo, connection);
        if (connection.opposite() != null) humanTo.addConnection(humanFrom, connection.opposite());
    }

    /**
     * Add wife to 'family' and set correct connections
     * 'family', 'husband' and 'wife' must exist and be members of this records
     */
    public void addWife(Family family, Human husband, Human wife) {
        addHumanToFamily(wife, family);
        addConnection(husband, FamilyConnection.HUSBAND, wife);
    }

    /**
     * Add child to 'family' and set correct connections
     * 'family', 'parent' and 'child' must exist and be members of this records
     */
    public void addChild(Family family, Human parent, Human child) {
        addHumanToFamily(child, family);
        addConnection(parent, FamilyConnection.PARENT, child);
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
        addConnection(parent, FamilyConnection.PARENT, child);
    }

    /**
     * return Set of Humans to whom this human is $connection
     */
    public Set<Human> findRelatedMembers(Human human, FamilyConnection connection) {
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
        return people;
    }

    public void save(Convertible converter) {
        converter.save(this);
    }
    public static FamilyRecords load(Convertible converter) {
        return converter.load();
    }
//    public void load(Convertible converter) {
//        // TODO: modify construction to something like 'this = converter.load();', when/if i understand how to do it
//        // Not sure if this way to load data is correct
//        FamilyRecords loadedRecords = converter.load();
//        this.people = loadedRecords.people;
//        this.families = loadedRecords.families;
//    }
}
