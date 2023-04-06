package person;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Person implements Serializable, Comparable<Person> {
    private String firstName;
    private String lastName;
    private boolean isMan;
    private Calendar bornDate;
    private Map<Person, Boolean> married;
    private List<Person> children;
    private List<Person> parents;

    public Person(String firstName, String lastName, boolean isMan) {
        this(firstName, lastName, isMan, new GregorianCalendar());
    }

    public Person(String firstName, String lastName, boolean isMan, Calendar bornDate) {
        this(firstName, lastName, isMan, bornDate, new HashMap<>(), new ArrayList<>(), new ArrayList<>());
    }

    public Person(Person person) {
        this(person.firstName, person.lastName, person.isMan, person.bornDate, person.married, person.children, person.parents);
        this.updateLinks();
    }

    private Person(String firstName, String lastName, boolean isMan, Calendar bornDate, Map<Person, Boolean> married, List<Person> children, List<Person> parents) {
        this.setName(firstName, lastName);
        this.isMan = isMan;
        this.married = married;
        this.bornDate = bornDate;
        this.children = children;
        this.parents = parents;
    }

    public void setName(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getName() {
        return this.getFirstName() + " " + this.getLastName();
    }

    public Calendar getBornDate() {
        return this.bornDate;
    }

    public Boolean getGender() {
        return this.isMan;
    }

    public List<Person> getChildren() {
        return this.children;
    }

    public List<Person> getParents() {
        return this.parents;
    }

    public Person getMarried() {
        if (this.married.containsValue(true)) {
            for (Map.Entry<Person, Boolean> entry : this.married.entrySet())
                if (entry.getValue() == true) return entry.getKey();
        }
        return null;
    }

    public void addMarried(Person married, boolean isMarried) {
        if (!this.hasMarried(married)) {
            this.married.put(married, isMarried);
            married.addMarried(this, isMarried);
        }
    }

    public void addChild(Person child) {
        if (!this.hasChild(child)) {
            this.children.add(child);
            child.addParent(this);
        }
    }

    public void addParent(Person parent) {
        if (!this.hasParent(parent)) {
            this.parents.add(parent);
            parent.addChild(this);
        }
    }

    public void updateLinks() {
        this.updateChildren();
        this.updateParents();
    }

    private void updateChildren() {
        if (this.countChildren() > 0) {
            for (Person person : this.children) {
                person.addParent(this);
            }
        }
    }

    private void updateParents() {
        if (this.countParents() > 0) {
            for (Person person : this.parents) {
                person.addChild(this);
            }
        }
    }

    public int countChildren() {
        return this.children.size();
    }

    private int countParents() {
        return this.parents.size();
    }

    public boolean hasMarried(Person married) {
        boolean result = false;
        if (this.married.containsKey(married)) result = true;
        return result;
    }

    public boolean hasChild(Person child) {
        boolean result = false;
        if (this.children.indexOf(child) != -1) result = true;
        return result;
    }

    private boolean hasParent(Person parent) {
        boolean result = false;
        if (this.parents.indexOf(parent) != -1) result = true;
        return result;
    }

    public String toString() {
        return this.getName();
    }

    public String toStringBornDate() {
        return this.toString() + " " + this.getBornDate();
    }

    public int compareTo(Person p) {
        int result = this.getFirstName().compareTo(p.getFirstName());
        if (result == 0) result = this.getLastName().compareTo(p.getLastName());
        if (result == 0) {
            if (this.bornDate.after(p.bornDate)) {
                result = 1;
            } else if (this.bornDate.before(p.bornDate)) {
                result = -1;
            }
            result = this.getBornDate().compareTo(p.getBornDate());
        }
        return result;
    }
}