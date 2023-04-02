import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Person implements Serializable {
    private String firstName;
    private String lastName;
    private boolean isMan;
    private Calendar bornDate;
    private Map<Person, Boolean> married;
    private List<Person> children;
    private List<Person> parents;
    private List<FamilyTree> inFamilyTrees;

    public Person(String firstName, String lastName, boolean isMan) {
        this(firstName, lastName, isMan, new GregorianCalendar());
    }

    public Person(String firstName, String lastName, boolean isMan, Calendar bornDate) {
        this(firstName, lastName, isMan, bornDate, new HashMap<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }

    public Person(Person person){
        this(person.firstName, person.lastName, person.isMan, person.bornDate, person.married, person.children, person.parents, person.inFamilyTrees);
    }

    private Person(String firstName, String lastName, boolean isMan, Calendar bornDate, Map<Person, Boolean> married, List<Person> children, List<Person> parents, List<FamilyTree> inFamilyTrees) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.isMan = isMan;
        this.married = married;
        this.bornDate = bornDate;
        this.children = children;
        this.parents = parents;
        this.inFamilyTrees = inFamilyTrees;
    }

    public void addMarried(Person married, boolean isMarried) {
        if (!this.hasMarried(married)) {
            this.married.put(married, isMarried);
            married.addMarried(this, isMarried);
        }
    }

    public Person Married() {
        if (this.married.containsValue(true)) {
            for (Map.Entry<Person, Boolean> entry : this.married.entrySet())
                if (entry.getValue() == true) return entry.getKey();
        }
        return null;
    }

    public void addChild(Person child) {
        if (!this.hasChild(child)) {
            this.children.add(child);
            child.addParent(this);
        }
    }

    public List<Person> getChildren() {
        return this.children;
    }

    public int countChildren() {
        return this.children.size();
    }

    public void addParent(Person parent) {
        if (!this.hasParent(parent)) {
            this.parents.add(parent);
            parent.addChild(this);
        }
    }

    public void addToFamilyTree(FamilyTree familyTree){
        if (!hasFamilyTree(familyTree)){
            this.inFamilyTrees.add(familyTree);
            familyTree.addPerson(this);
        }
    }

    public boolean hasParent(Person parent) {
        boolean result = false;
        for (Person person : this.parents) {
            if (person == parent) {
                result = true;
            }
        }
        return result;
    }

    public boolean hasChild(Person child) {
        boolean result = false;
        for (Person person : this.children) {
            if (person == child) {
                result = true;
            }
        }
        return result;
    }

    public boolean hasFamilyTree(FamilyTree familyTree) {
        boolean result = false;
        for (FamilyTree fTree : this.inFamilyTrees) {
            if (fTree == familyTree) {
                result = true;
            }
        }
        return result;
    }

    public boolean hasMarried(Person married) {
        boolean result = false;
        if (this.married.containsKey(married)) result = true;
        return result;
    }

    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}